/*
 * Copyright 2024 XianZhi Group
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import {createRouter, createWebHistory, RouteRecordRaw} from 'vue-router'
import Layout from '@/layout/Index.vue'
import NProgress from 'nprogress'
// 引入进度条样式
import 'nprogress/nprogress.css'
import {getCurrentUserResource, ResourceVO} from "@/api/resourceApi.ts";
import {message} from "ant-design-vue";
import {useUserStore} from "@/stores/modules/user.ts";
import {useRouterStore} from "@/stores/modules/router.ts";


const routes = [
  {
    path: "/",
    redirect: "/home",
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/views/Login.vue'),
    meta: {
      requiresAuth: false
    }
  },
  {
    path: '/home',
    name: 'home',
    component: Layout,
    children: [],
  },
  {
    path: '/:pathMatch(.*)*',
    component: () => import('@/views/error/404.vue')
  }

]
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
  //使用浏览器的回退或者前进时，重新返回时保留页面滚动位置，跳转页面的话，不触发。
  scrollBehavior(to, from, savePosition) {
    if (savePosition) {
      return savePosition;
    } else {
      return {top: 0};
    }
  }
})


const modulesRoutes = import.meta.glob("/src/views/**/*.{vue,tsx}");
const modulesRoutesKeys = Object.keys(modulesRoutes);
router.beforeEach(async (to, from, next) => {

  NProgress.start();
  const userStore = useUserStore()
  const routerStore = useRouterStore()
  if (userStore.isLogin){
    if (to.path === '/login') {
      next()
      return
    }
    if (routerStore.routers.length === 0) {
      console.log("111")
      const currentUserResource = await getCurrentUserResource()
      if (!currentUserResource.data) {
        message.error('获取用户信息失败')
        next({ path: '/login' })
        return
      }
      const asyncRouter = generateRoutes(currentUserResource.data)
      routerStore.setRouterList(asyncRouter.children)
      router.addRoute(asyncRouter)
      next({path: '/home/dashboard'})
    }else{
      next()
    }

  }else{
    if (to.path === '/login') {
      next()
    } else {
      next({ path: '/login', query: { redirect: to.path } })
      message.error('请先登录')
    }
  }

});


function generateRoutes(items: Array<ResourceVO>): RouteRecordRaw {
  const homeRoutes = routes.filter(item => item.path === '/home')[0]
  homeRoutes.children = []
  items.forEach(item => {
    homeRoutes.children?.push(convertChildren(item))
  })
  return homeRoutes
}

function convertChildren(item: ResourceVO): RouteRecordRaw {
  const route = {
    path: item.resourceKey,
    name: item.resourceName,
    meta: {
      title: item.resourceName,
      icon: item.menuIcon,
      menuShowFlag: item.showFlag,
    },
  }
  const index = item?.menuComponent
    ? modulesRoutesKeys.findIndex(ev => ev.includes(item.menuComponent as any))
    : modulesRoutesKeys.findIndex(ev => ev.includes(item.menuRouter))
  if (item.children) {
    // 菜单有子集
    if (item.children[0].resourceType === ResourceType.MENU) {
      route.children = item.children.map(child => {
        return convertChildren(child)
      })
      // 菜单没有子集，为这个菜单添加权限标识
    } else if (item.children[0].resourceType === ResourceType.BUTTON) {
      // 菜单对应的组件
      route.component = modulesRoutes[modulesRoutesKeys[index]]
      route.meta = {
        // 这个菜单对应的所有按钮权限
        authors: item.children,
      }
    }
  } else {
    route.component = modulesRoutes[modulesRoutesKeys[index]]
  }
  return route
}


export default router
