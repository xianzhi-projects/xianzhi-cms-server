<!--
  - Copyright 2024 XianZhi Group
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  -->

<template>
  <div class="login-page">
    <!-- 背景地球效果 -->
    <div class="background"></div>

    <!-- 登录表单 -->
    <div class="login-container">
      <a-form
        :model="passwordLoginDTO"
        layout="vertical"
        @submit="handleLogin"
      >
        <h2 class="title">后台系统登录</h2>

        <a-form-item>
          <a-input
            v-model:value="passwordLoginDTO.account"
            placeholder="请输入用户名"
          >
            <template #prefix>
              <UserOutlined class="site-form-item-icon"/>
            </template>
          </a-input>
        </a-form-item>

        <a-form-item>
          <a-input-password
            v-model:value="passwordLoginDTO.password"
            placeholder="请输入密码">
            <template #prefix>
              <LockOutlined class="site-form-item-icon"/>
            </template>
          </a-input-password>
        </a-form-item>

        <a-form-item>
          <a class="x-right" href="">忘记密码?</a>
        </a-form-item>

        <a-form-item>
          <a-button
            type="primary"
            block
            @click="handleLogin"
          >
            登录
          </a-button>
        </a-form-item>

        <!--        <a href="#" class="quick-login">快捷登录</a>-->
      </a-form>
    </div>
  </div>
</template>

<script lang="ts" setup>
import {ref} from 'vue';
import {LockOutlined, UserOutlined} from '@ant-design/icons-vue';
import {message} from 'ant-design-vue';
import {passwordLogin, type PasswordLoginDTO,TokenVO} from "@/api/authApi.ts";
import router from "@/router/index.ts";
import {useUserStore} from "@/stores/modules/user.ts";

const passwordLoginDTO = ref<PasswordLoginDTO>({
  account: '',
  password: ''
})
const handleLogin = async () => {
  if (!passwordLoginDTO.value.account || !passwordLoginDTO.value.password) {
    message.error('请输入用户名和密码');
    return;
  }
  const result = await passwordLogin(passwordLoginDTO.value);
  if (result.success) {
    message.success(result.message);
    router.push("/dashboard");
    const userStore = useUserStore();
    userStore.setUser(result.data as TokenVO);
    return
  }
  message.error(result.message);
};
</script>

<style lang="less" scoped>

/* 页面整体样式 */
.login-page {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #0A2A52;
  position: relative;
  overflow: hidden;
}

/* 背景地球效果，可以自定义背景图片 */
.background {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-image: url('../assets/images/back.webp'); // 替换为背景图路径
  background-size: cover;
  background-position: center;
  filter: blur(0px); // 模糊效果
}

/* 登录表单容器 */
.login-container {
  background-color: #ffffff;
  padding: 40px;
  width: 420px;
  border-radius: 8px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
  text-align: center;
  position: relative;
  z-index: 1;
}

/* 标题样式 */
.title {
  font-size: 20px;
  font-weight: 600;
  color: #333;
  margin-bottom: 20px;
}

/* 快捷登录链接样式 */
.quick-login {
  display: block;
  margin-top: 10px;
  color: #347AF7;
  font-size: 12px;
  text-decoration: none;
  float: left;
}

.quick-login:hover {
  text-decoration: underline;
}
</style>

