import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import Components from 'unplugin-vue-components/vite';
import {AntDesignVueResolver} from 'unplugin-vue-components/resolvers';
import path from 'path'


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue({
    script: {
      defineModels: true
    }
  }),
    Components({
      resolvers: [
        AntDesignVueResolver({
          importStyle: false, // css in js
        }),
      ],
    }),],


  server: {
    port: 3000,
    open: true,
    host: '0.0.0.0',
    proxy: {
      "/api": {
        target: "http://127.0.0.1:8888/",
        changeOrigin: false,
        ws: true,
        rewrite: (path) => path.replace(/^\/api/, "")
      }
    }
  },
  resolve: {
    alias: {
      "@": path.resolve("./src") // 相对路径别名配置，使用 @ 代替 src
    }
  }

})


