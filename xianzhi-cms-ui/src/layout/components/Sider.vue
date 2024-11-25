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

<script setup lang="ts">

import {collapsed} from "@/layout/layout.ts";
</script>

<template>
  <a-layout-sider
    breakpoint="lg"
    @collapse="collapsed"
    @breakpoint="onBreakpoint"
    :collapsed-width="80"
    :trigger="null"
    collapsible
    width="280"
  >
    <div class="logo"/>
    <a-menu v-model:selectedKeys="selectedKeys" theme="dark" mode="inline">
      <a-menu-item key="1">
        <user-outlined/>
        <span class="nav-text">nav 1</span>
      </a-menu-item>
      <a-menu-item key="2">
        <video-camera-outlined/>
        <span class="nav-text">nav 2</span>
      </a-menu-item>
      <a-menu-item key="3">
        <upload-outlined/>
        <span class="nav-text">nav 3</span>
      </a-menu-item>
      <a-menu-item key="4">
        <user-outlined/>
        <span class="nav-text">nav 4</span>
      </a-menu-item>
    </a-menu>
  </a-layout-sider>
</template>

<style scoped lang="less">

.ant-layout-sider {
  overflow: auto;
  height: 100vh;
  position: fixed;
  left: 0;
}

</style>
