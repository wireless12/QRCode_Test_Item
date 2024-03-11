import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: () => import('@/views/HomeView.vue'),
    meta:{
      title: '欢迎登陆Vx'
    }
  },
  {
    path: '/test',
    name: 'test',
    component: () => import('@/views/TestView.vue'),
    meta:{
      title: '测试页面'
    }
  },
  {
    path: '/mobileIndex',
    name: 'mobileIndex',
    component: () => import('@/views/MobileHomeView.vue'),
    meta:{
      title: 'Vx'
    }
  },
  {
    path: '/confirmLogin',
    name: 'confirmLogin',
    component: () => import('@/views/ConfirmLoginView.vue'),
    meta:{
      title: '确认登陆'
    }
  },
  {
    path: '/loginSuccessful',
    name: 'loginSuccessful',
    component: () => import('@/views/LoginSuccessfulView.vue'),
    meta:{
      title: '电脑网页端登陆成功测试页面'
    }
  }
]
const router = createRouter({
  history: createWebHistory(),
  routes
})
router.beforeEach((to, from, next) => {
  document.getElementById('title').innerHTML = to.meta.title
  let token = localStorage.getItem('userToken')
  // console.log(token)
  if(token===null || token=== '') {
    if(to.path==='/') {
      next()
    } else {
      router.push('/')
    }
  } else {
    next()
  }
})
export default router
