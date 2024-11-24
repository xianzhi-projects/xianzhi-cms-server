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
import type {AxiosInstance, AxiosRequestConfig, AxiosResponse} from 'axios';
import axios, {AxiosError} from 'axios';
import {message} from "ant-design-vue";
import {useUserStore} from "@/stores/modules/user.ts";

export interface ResponseResult<T> {
  success: boolean;
  message: string;
  data: T | null;
  traceId: string;
}

class HttpRequest {
  private readonly baseUrl: string;

  constructor() {
    this.baseUrl =  'http://localhost:3000/api';
  }

  private getInsideConfig(): AxiosRequestConfig {
    return {
      baseURL: this.baseUrl,
      timeout: 80000,
      withCredentials: true,
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + useUserStore().getUser().accessToken,
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
  }

  private interceptors(instance: AxiosInstance) {
    instance.interceptors.request.use(config => {
      // 可以在这里添加全局的 loading 或者其他的处理
      return config;
    }, (error: AxiosError) => {
      return Promise.reject(error);
    });

    instance.interceptors.response.use(response => {
      const {success, code} = response.data;

      if (success && code === '200') {
        return response;
      }

      switch (code) {
        case '401':
          message.error('未授权，请登录');
          break;
        case '403':
          message.error('没有权限');
          break;
        default:
          message.error(response.data.message);
      }
      return response;
    }, (error: AxiosError) => {
      if (error.response) {
        const status = error.response.status;
        switch (status) {
          case 400:
            message.error('请求错误');
            break;
          case 401:
            message.error('未授权，请登录');
            break;
          case 403:
            message.error('禁止访问');
            break;
          case 404:
            message.error('请求地址出错');
            break;
          case 500:
            message.error('服务器内部错误');
            break;
          default:
            message.error('系统错误');
            break;
        }
      } else {
        message.error('网络异常');
      }
      return Promise.reject(error);
    });
  }

  public request<T>(options: AxiosRequestConfig): Promise<ResponseResult<T>> {
    const instance = axios.create();
    options = {...this.getInsideConfig(), ...options};
    this.interceptors(instance);
    return instance.request<ResponseResult<T>>(options)
      .then((response: AxiosResponse<ResponseResult<T>>) => {
        return response.data; // 返回完整的 ResponseResult<T>
      });
  }
}

const http = new HttpRequest();
export default http;

