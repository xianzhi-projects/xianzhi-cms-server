
import { createApp } from 'vue'
import { createPinia } from 'pinia'

import Antd from 'ant-design-vue';
import App from './App.vue';
import '@/assets/rest.less';
import router from './router'
import * as antIcons from '@ant-design/icons-vue'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(Antd)

app.mount('#app')



// 注册 ant-design 图标
Object.keys(antIcons).forEach((key) => {
  app.component(key, antIcons[key as keyof typeof antIcons])
})

app.config.globalProperties.$antIcons = antIcons
