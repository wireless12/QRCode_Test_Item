<template>
  <div class="container">
      <div @click="closeCameras()" v-show="closeFlag" class="closeBtn">
        <svg style="width: 40px;" t="1709866832270" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="8552" width="200" height="200"><path d="M512 102.4a409.6 409.6 0 1 0 409.6 409.6 409.6 409.6 0 0 0-409.6-409.6z m181.248 518.144a51.2 51.2 0 0 1-72.704 72.704L512 584.192l-108.544 109.056a51.2 51.2 0 0 1-72.704-72.704L439.808 512 330.752 403.456a51.2 51.2 0 0 1 72.704-72.704L512 439.808l108.544-109.056a51.2 51.2 0 0 1 72.704 72.704L584.192 512z" fill="#ffffff" p-id="8553"></path></svg>
      </div>
      <div id="reader"></div>
      
  </div>
</template>
<script setup>
import { reactive, onMounted, onUnmounted, inject, ref } from 'vue'
import router from '@/router/index'
import { Html5Qrcode } from 'html5-qrcode'

onMounted(() => {
  getCameras()
  setTimeout(()=>{
    closeFlag.value = true
  },2400)
})
onUnmounted(() => {
  stop()
})
const closeFlag = ref(false)
const html5QrCode = ref(null)
const getCameras = () => {
  Html5Qrcode.getCameras()
    .then((devices) => {
      if (devices && devices.length) {
        html5QrCode.value = new Html5Qrcode('reader')
        //开始扫描
        start()
      }
    })
    .catch((err) => {
      console.log('获取设备信息失败', err) // 获取设备信息失败
    })
}
const start = () => {
  html5QrCode.value
    .start(
      {facingMode: "environment" },
      {
        fps: 10, // 设置每秒多少帧
        qrbox: { width: 300, height: 300 }, // 设置取景范围
        aspectRatio: 2.1 // 设置屏幕比 10:16适应手机屏幕
      },
      (decodedText, decodedResult) => {
        let textList = decodedText.split(',')
        let address = textList[0]
        let loginId = textList[1]
        // alert('扫码结果\n' + '扫码登陆地点:' + address + '\n'+'登陆ID:' + loginId)
        localStorage.setItem('loginAddress',address)
        localStorage.setItem('loginId',loginId)
        router.push('./confirmLogin')
      },
      (errorMessage) => {
          // console.log('暂无额扫描结果', errorMessage)
      }
    )
    .catch((err) => {
      console.log(err,errorMessage)
    })
}
const closeCameras = () => {
  router.push('./mobileIndex')
}
const stop = () => {
  html5QrCode.value.stop().then((ignore) => {
    console.log('QR Code scanning stopped.', ignore)
  })
  .catch((err) => {
    console.log('Unable to stop scanning.', err)
  })
}
</script>

<style scoped>
.container{
  background-color: black;
  width: 100%;
  height: 100vh;
  overflow: hidden;
}
#reader {
  /* position: absolute; */
  width: 100%;
  height: auto;
}
.closeBtn{
  position: fixed;
  top: -60px;
  left: 10px;
  z-index: 999;
}
</style>
