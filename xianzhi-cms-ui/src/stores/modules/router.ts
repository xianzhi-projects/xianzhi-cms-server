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
import {defineStore} from 'pinia';
import {ref} from 'vue';
import type {RouteRecordRaw} from 'vue-router';

export const useRouterStore = defineStore('router', () => {
  const routers = ref<Array<RouteRecordRaw>>([]);

  /**
   * 设置路由信息
   * @param routerList 路由信息
   */
  function setRouterList(routerList: RouteRecordRaw[] | undefined) {
    routers.value = routerList || []; // 如果 routerList 为 undefined，则赋值为空数组
  }

  return { routers, setRouterList };
});
