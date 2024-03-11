<template>
  <div class="mobileBody">
    <Row>
      <Col style="height: 100vh;" flex="auto">
        <div style="height: 60px;"></div>
        <List style="padding: 5px;">
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.ff59621a.ivvfcUY5dAgxv00xiw6Jlw?t=1659414767" title="还没想好备注" description="5090显卡怎么样？" />
              <template #action>
                  <li>
                      <a  href="">15分钟前</a>
                  </li>
              </template>
            </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.5f7ccaef.9nIYcAusSC1Yrs8dcsLhqQ?t=1689085456" title="哥们" description="整挺好" />
              <template #action>
                  <li>
                      <a  href="">3小时前</a>
                  </li>
              </template>
            </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.edb43311.8isCbMmmR7Q6zATuIjuMyg?t=1669683382" title="牢师" description="[狗头][狗头]" />
              <template #action>
                  <li>
                      <a  href="">昨天</a>
                  </li>
              </template>
          </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.f0edcc9b.5HoNVPpdnIahU2jVpUHudw?t=1690791635" title="元神巅峰赛小袋" description="牢弟,深渊帮你打到巅峰3000了" />
              <template #action>
                  <li>
                      <a  href="">昨天</a>
                  </li>
              </template>
          </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.cb2c6862.-XB3oeS1GtD9sT-KYgAoaQ?t=1687130534" title="门将哥" description="？？" />
              <template #action>
                  <li>
                      <a  href="">2024/3/9</a>
                  </li>
              </template>
          </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.1344e190.cInljwzoZBpGJ51rcUAdFg?t=1707302211" title="游戏高手" description="无语了。。。。" />
              <template #action>
                  <li>
                      <a  href="">2024/3/9</a>
                  </li>
              </template>
          </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.b470738c.OxmMJloQZF2JFsZi-Ww7wA?t=1705226800" title="王者大神" description="(暂无消息)" />
              <template #action>
                  <li>
                      <a  href="">2024/3/8</a>
                  </li>
              </template>
          </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.c57d355.4SBbwfvwTi0ddMU1xCTnvg?t=1709941358" title="" description="(暂无消息)" />
              <template #action>
                  <li>
                      <a  href="">2024/2/24</a>
                  </li>
              </template>
          </ListItem>
          <ListItem>
              <ListItemMeta avatar="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.55be037.5gcYCzPT222tPJLloLmrvg?t=1675642410" title="???" description="(暂无消息)" />
              <template #action>
                  <li>
                      <a  href="">2024/2/22</a>
                  </li>
              </template>
          </ListItem>
        </List>
        <div style="height: 55px;"></div>
      </Col>
    </Row>
    <div class="topBar">
      <Row>
        <Col  span="4">
          
        </Col>
        <Col style="padding: 10px;" span="20">
          <!-- <div style="color: white;">Vx</div> -->
          <Input placeholder="搜索/添加" @on-enter="value2=true" style="width: 85%" />
          <Button style="color: white;background: none;" type="text" icon="md-expand" @click="toGetQrCode" size="large"></Button>
        </Col>
      </Row>
      <div class="topBar" style="top:-70px">
        <svg style="width: 30px;margin-left: 15px;" t="1709777700453" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2483" width="200" height="200"><path d="M1022.588147 511.294073c0-282.916054-228.378019-511.294073-511.294074-511.294073S0 228.378019 0 511.294073s228.378019 511.294073 511.294073 511.294074c20.451763 0 44.312153-3.408627 64.763916-3.408628 34.086272 3.408627 74.989797 6.817254 115.893324 3.408628 132.936459-3.408627 228.378019-34.086272 286.324681-57.946662-37.494899-6.817254-92.032933-20.451763-153.388222-47.72078C944.189722 821.479144 1022.588147 674.908177 1022.588147 511.294073zM255.647037 426.078394c0-37.494899 30.677644-68.172543 68.172543-68.172543s68.172543 30.677644 68.172543 68.172543-30.677644 68.172543-68.172543 68.172544-68.172543-30.677644-68.172543-68.172544zM756.715229 681.725431c-44.312153 85.215679-129.527832 136.345086-228.37802 136.345086-95.44156 0-180.657239-51.129407-224.969392-136.345086-3.408627-6.817254 0-17.043136 6.817254-23.86039 6.817254-3.408627 17.043136 0 23.86039 6.817254 37.494899 71.58117 112.484696 119.30195 197.700375 119.301951 81.807052 0 156.796849-44.312153 197.700375-119.301951 3.408627-6.817254 13.634509-10.225881 23.86039-6.817254 3.408627 3.408627 6.817254 13.634509 3.408628 23.86039z m10.225881-177.248612l-190.883121-47.72078c-3.408627 0-3.408627-3.408627-6.817254-3.408627 0 0 0-3.408627-3.408627-3.408627v-3.408628-6.817254c0-6.817254 3.408627-10.225881 6.817254-13.634509L749.897974 330.636834c6.817254-3.408627 13.634509 0 17.043136 10.225882s0 17.043136-6.817254 23.86039l-136.345087 71.58117 146.570968 37.494899c6.817254 3.408627 13.634509 10.225881 10.225882 20.451763 0 6.817254-6.817254 13.634509-13.634509 10.225881z" fill="#ffffff" p-id="2484"></path></svg>
      </div>
    </div>
    <div class="bottomBar">
      <div style="position: absolute;top: 20px;width: 100%;  background: rgb(255, 255, 255);
          border-top:rgb(224, 222, 222) solid 1px;height: 50px;">
        <Row>
        <Col span="8">
          <div style="margin-top: 13px;">
            <Notification icon="ios-chatbubbles" :count="0" />
            <Notification icon="md-contacts" style="margin-left: 15%;margin-right: 15%;"  :count="2" />
            <Notification icon="ios-folder"  :count="0" />
          </div>
        </Col>
        <Col span="8">
        </Col>
        <Col span="8">
          <div style="margin-top: 13px;">
            <Notification icon="md-aperture" style="margin-left: -15%;" :count="4" />
            <Notification icon="ios-cog" style="margin-left: 15%;margin-right: 15%;"  :count="0" />
            <Notification icon="md-exit"  :count="0" />
          </div>
        </Col>
      </Row>
      </div>
      <div style="position: absolute;height: 69px;width: 69px;border-radius: 40px;left: 40.5%;border:rgb(7, 6, 6) solid 1px;overflow: hidden;">
        <img style="width: 100%;" src="https://gss0.bdstatic.com/6LZ1dD3d1sgCo2Kml5_Y_D3/sys/portrait/item/tb.1.bf75aa2e.PQ_Gjr9ORJCHcXrAqdHuTw?t=1701176760" alt="">
      </div>
    </div>
    <Drawer height="40" placement="top" :closable="false" v-model="value2">
      <p>Some contents...</p>
    </Drawer>
  </div>
</template>
<script setup>
import { reactive, inject, onMounted, onDeactivated, ref } from 'vue'
import router from '@/router/index'
const testValue = ref(0)
const value2 = ref(false)
const toGetQrCode = () => {
  router.push('./test')
}
const test = () => {
  if(testValue.value === 0) {
    testValue.value++
  }else{
    alert('设置头像')
  }
}
const test2 =() => {
  testValue.value-=1
}
</script>
<style scoped>
.bottomBar{
  text-align: center;
  position: fixed;
  bottom: 0;
  height: 70px;
  width: 100%;
}
.topBar{
  position: fixed;height: 60px;
  top:0;width: 100%;
  background: linear-gradient(-65deg, #ffb0cd, #359dc4);
}
</style>