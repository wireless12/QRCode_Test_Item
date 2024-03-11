<template>
  <div style="text-align: center;">
    扫码登陆成功👌
    <h2>登陆签名:</h2>
    <h3>{{ token }}</h3>
  </div>
</template>

<script setup>
import { reactive, inject, onMounted, onDeactivated, ref } from 'vue'
const token = ref(localStorage.getItem('userToken'))
</script>
