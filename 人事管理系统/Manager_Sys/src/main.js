// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Axios from 'axios'

import '../src/assets/css/public.css'   // 引入公共样式

// 引入ElementUI框架
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);

Vue.config.productionTip = false

Vue.prototype.$axios = Axios
// 解决axios跨域问题,1.配置main.js
Axios.defaults.baseURL = '/api'
// 前后端传数据
Axios.defaults.headers.post['Content-Type'] = 'application/json'

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
