<template>
  <div class="home">
    <div style="text-align: center;">
      <svg style="width: 100px;" t="1709777700453" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2483" width="200" height="200"><path d="M1022.588147 511.294073c0-282.916054-228.378019-511.294073-511.294074-511.294073S0 228.378019 0 511.294073s228.378019 511.294073 511.294073 511.294074c20.451763 0 44.312153-3.408627 64.763916-3.408628 34.086272 3.408627 74.989797 6.817254 115.893324 3.408628 132.936459-3.408627 228.378019-34.086272 286.324681-57.946662-37.494899-6.817254-92.032933-20.451763-153.388222-47.72078C944.189722 821.479144 1022.588147 674.908177 1022.588147 511.294073zM255.647037 426.078394c0-37.494899 30.677644-68.172543 68.172543-68.172543s68.172543 30.677644 68.172543 68.172543-30.677644 68.172543-68.172543 68.172544-68.172543-30.677644-68.172543-68.172544zM756.715229 681.725431c-44.312153 85.215679-129.527832 136.345086-228.37802 136.345086-95.44156 0-180.657239-51.129407-224.969392-136.345086-3.408627-6.817254 0-17.043136 6.817254-23.86039 6.817254-3.408627 17.043136 0 23.86039 6.817254 37.494899 71.58117 112.484696 119.30195 197.700375 119.301951 81.807052 0 156.796849-44.312153 197.700375-119.301951 3.408627-6.817254 13.634509-10.225881 23.86039-6.817254 3.408627 3.408627 6.817254 13.634509 3.408628 23.86039z m10.225881-177.248612l-190.883121-47.72078c-3.408627 0-3.408627-3.408627-6.817254-3.408627 0 0 0-3.408627-3.408627-3.408627v-3.408628-6.817254c0-6.817254 3.408627-10.225881 6.817254-13.634509L749.897974 330.636834c6.817254-3.408627 13.634509 0 17.043136 10.225882s0 17.043136-6.817254 23.86039l-136.345087 71.58117 146.570968 37.494899c6.817254 3.408627 13.634509 10.225881 10.225882 20.451763 0 6.817254-6.817254 13.634509-13.634509 10.225881z" fill="#ffffff" p-id="2484"></path></svg>
    </div>
    <div class="demo-login">
      <div style="text-align: center;margin-bottom: 20px;" v-if="showFlag">
        <Button type="text" style="color:white;background: none;" icon="md-desktop" @click="qrCodeShowFlag = false">密码登陆</Button>
        <Button type="text" style="color:white;background: none;" icon="md-expand" @click="qrCodeShowFlag = true">扫码登陆</Button>
      </div>
      <transition name="move-left">
        <div style="position: absolute;" v-show="!qrCodeShowFlag">
          <Input size="large" prefix="md-person" v-model="userName" placeholder="用户名" style="width: 300px" />
          <br>
          <br>
          <Input size="large" prefix="md-lock" type="password" password v-model="password" placeholder="密码" style="width: 300px" />
          <div class="demo-auto-login">
            <Checkbox v-model="autoLogin" style="color: white;" size="default">自动登录</Checkbox>
            <a style="color: white;">忘记密码</a>
          </div>
          <div style="text-align: center;">
            <Button @click="login()" shape="circle" type="dashed" ghost icon="md-play" style="font-size: 30px;height: 55px;" size="large" v-width="250">进入VX</Button>
          </div>
        </div>
      </transition>
      <transition name="move-right">
        <div style="text-align: center;position: absolute;" v-show="qrCodeShowFlag">
          <img style="border-radius: 10px;" :src='qrCodePath' alt="二维码">
          <div style="text-align: center;color: white;">请使用Vx移动端扫码登陆</div>
        </div>
      </transition>
    </div>
  </div>
</template>

<script setup>
import { reactive, inject, onMounted, onDeactivated, ref } from 'vue'
import router from '@/router/index'
onMounted(() => {
  //因为没编写注销账号所以得先移除token
  localStorage.removeItem('userToken')
  const sUserAgent = navigator.userAgent.toLowerCase()
  if (/ipad|iphone|midp|rv:1.2.3.4|ucweb|android|windows ce|windows mobile/.test(sUserAgent)) {
    showFlag.value = false
  } else {
    getLocation()
  } 
})
const loginId = ref('')
const qrCodePath = ref('')
const qrCodeShowFlag = ref(false)
const showFlag = ref(true)
const address = ref('')
const userName = ref('')
const password = ref('')
const autoLogin = ref(false)
const axios = inject('$axios')
const login = () => {
  axios({
    method: 'post',
    url: 'http://192.168.100.47:8089/user/login',
    params: {
      name: userName.value,
      password: password.value
    }
  }).then((res => {
    if(res.data !== 'error') {
      if(showFlag.value) {
        return;
      }
      let userData = res.data
      let token = userData.split('%and%')[0]
      let userId = userData.split('%and%')[1]
      localStorage.setItem("userToken", token)
      localStorage.setItem("uid", userId)
      router.push('./mobileIndex')
    }
  }))
}
const qrLogin = (userName,uid) => {
  axios({
    method: 'post',
    url: 'http://192.168.100.47:8089/user/qr/login',
    params:{
      name:userName,
      userId: uid
    }
  }).then((res) => {
    if(res.data!=='error') {
      let userData = res.data
      let token = userData.split('%and%')[0]
      let userId = userData.split('%and%')[1]
      localStorage.setItem("userToken", token)
      localStorage.setItem("uid", userId)
      router.push('./loginSuccessful')
    }
  })
}
const getLocation = ()=>{
  axios({
    method: 'get',
    url: '/ipplus'
  }).then((res) => {
    address.value = res.data.data
    loginId.value= `Vx-${generateRandomString(7)}-${new Date().getTime()}-${generateRandomString(6)}-${generateRandomString(9)}`
    showFlag.value = true
    path.value = `ws://192.168.100.47:8089/websocket/${loginId.value}`
    qrCodePath.value = `http://192.168.100.47:8089/qr/login/qr?address=${address.value}&loginId=${loginId.value}`
    initMethod()
  })
}
const generateRandomString = (length) => {
  const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';

  return Array.from({ length })
    .reduce((result) => result + characters.charAt(Math.floor(Math.random() * characters.length)), '');
}

//websocket相关属性
const path = ref('')//ws通信地址 格式:ws://域名或地址/通信连接名/{通信ID}
const socket = reactive({ data: {} })
const initMethod = () => {
  if (typeof (WebSocket) === 'undefined') {
    alert('您的浏览器不支持socket')
  } else {
    // 实例化socket
    socket.data = new WebSocket(path.value)
    // 监听socket连接
    socket.data.onopen = openMethod
    // 监听socket错误信息
    socket.data.onerror = errorMethod
    // 监听socket消息
    socket.data.onmessage = getMessageMethod
  }
}
const openMethod = () => {
  console.log('socket连接成功')
}
const errorMethod = () => {
  console.log('连接错误')
}
const getMessageMethod = (msg) => {
  console.log(msg.data)
  let userName = msg.data.split('&')[1]
  let uid = msg.data.split('&')[0]
  qrLogin(userName,uid)
}
const sendMethod = (params) => {
  socket.data.send(params)
}

</script>
<style scoped>
.home{
  /* position: relative; */
  /* display: flex; */
  width: 100%;
  height: 100vh;
  /* overflow: hidden; */
  /* background-color: pink; */
  background: linear-gradient(-65deg, #aeff78, #ffb0cd, #359dc4, #ff5e00);
  background-size: 200% 200%;
  animation: bgcolor 3s ease-in-out infinite;
  /* border: 5px solid pink; */
}
.demo-login{
    margin: 0 auto;
    /* margin-top: 100px; */
    width: 300px;
}
.demo-auto-login{
    margin-bottom: 24px;
    text-align: left;
}
.demo-auto-login a{
    float: right;
}
.test{
  width: 100px;
  height: 100px;
  display: inline-block;
}
</style>
