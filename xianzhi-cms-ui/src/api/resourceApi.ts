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
import http, {ResponseResult} from "@/api/index.ts";

export enum ResourceType {

  /**
   * 菜单
   */
  MENU = 'MENU',
  /**
   * 按钮
   */
  BUTTON = 'BUTTON',
  /**
   * 链接
   */
  LINK = 'LINK',
  /**
   * 目录
   */
  DIRECTORY = 'DIRECTORY'


}

export interface ResourceVO {
  /**
   * 资源ID
   */
  id: string;
  /**
   * 资源名称
   */
  resourceName: string;
  /**
   * 资源类型
   */
  resourceType: ResourceType;
  /**
   * 资源描述
   */
  resourceDesc: string;
  /**
   * 资源key，如果是菜单的话就是菜单的路由。如果是链接的话就是链接地址，如果是按钮的话就是权限标识
   */
  resourceKey: string;
  /**
   * 菜单ICON
   */
  menuIcon: string;
  /**
   * 菜单组件
   */
  menuComponent: string;
  /**
   * 菜单排序
   */
  menuSort: number;
  /**
   * 是否显示
   */
  showFlag: boolean;
  /**
   * 子集菜单
   */
  children: Array<ResourceVO>;
}

/**
 * 获取当前用户所具有的资源信息
 */
export function getCurrentUserResource(): Promise<ResponseResult<Array<ResourceVO>>> {
  return http.request({
    url: '/resource/getCurrentUserResource',
    method: 'get'
  })
}
