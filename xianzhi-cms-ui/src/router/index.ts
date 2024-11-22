import {createRouter, createWebHistory} from 'vue-router'
import Layout from '@/layout/Index.vue'
import 'nprogress/nprogress.css'


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

export default router
