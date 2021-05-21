import 'core-js/stable'
import Vue from 'vue'
import App from './App'
import router from './router'
import CoreuiVue from '@coreui/vue'
import { iconsSet as icons } from './assets/icons/icons.js'
import store from './store'

// Recomendation of babeljs (https://babeljs.io/docs/en/babel-polyfill)
//import 'core-js/stable'; // only stable feature also is possible with only `core-js`
import 'regenerator-runtime/runtime'; // To ensure that regeneratorRuntime is defined globally

Vue.config.performance = true
Vue.use(CoreuiVue)
Vue.prototype.$log = console.log.bind(console)

new Vue({
  el: '#app',
  router,
  store,
  icons,
  template: '<App/>',
  components: {
    App
  }
})
