import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ViewUIPlus from 'view-ui-plus'
import axios from 'axios'
import 'view-ui-plus/dist/styles/viewuiplus.css'
const app = createApp(App)
app.use(store).use(router).use(ViewUIPlus).mount('#app')
app.provide('$axios', axios)
