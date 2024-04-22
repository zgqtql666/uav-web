<template>
  <div
    class="login flex-column flex-justify-center flex-align-center m0 b0">
    <!-- 项目学习1：下面的代码使用Flexbox布局的登录区域，其中包含一个可动态指定来源的图片元素，图片的样式和尺寸也有明确的设置。 -->
    <!-- 项目学习1：src属性的值将从组件的gdutLogo数据属性中获取。gdutLogo应该是一个变量，存储了图片资源的路径或URL。 -->
    <a-image
      style="width: 17vw; height: 17vw; margin-bottom: 50px"
      :src="gdutLogo"
    />
    <p class="fz35 pb50" style="color: #dae4f0">云集千翼</p>
    <a-form
      layout="inline"
      :model="formState"
      class="flex-row flex-justify-center flex-align-center"
    >
      <a-form-item>
        <a-input v-model:value="formState.username" placeholder="Username">
          <template #prefix
            ><UserOutlined style="color: rgba(0, 0, 0, 0.25)"
          /></template>
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-input
          v-model:value="formState.password"
          type="password"
          placeholder="Password"
        >
          <template #prefix
            ><LockOutlined style="color: rgba(0, 0, 0, 0.25)"
          /></template>
        </a-input>
      </a-form-item>
      <a-form-item>
        <a-button
          class="m0"
          type="primary"
          html-type="submit"
          :disabled="loginBtnDisabled"
          @click="onSubmit"
        >
          login
        </a-button>
      </a-form-item>
    </a-form>
  </div>

</template>

<script lang="ts" setup>
import gdutLogo from '/@/assets/icons/上云白.png'
import { LockOutlined, UserOutlined } from '@ant-design/icons-vue'
import { message } from 'ant-design-vue'
import { reactive, computed, UnwrapRef } from 'vue'
import { login, LoginBody } from '/@/api/manage'
import { getRoot } from '/@/root'
import { ELocalStorageKey, ERouterName, EUserType } from '/@/types'
import router from '/@/router'
import { consoleLog } from '/@/utils/logger'

const root = getRoot()

const formState: UnwrapRef<LoginBody> = reactive({
  username: '18号机', // 测
  password: 'adminPC',
  flag: EUserType.Web,
})

const loginBtnDisabled = computed(() => {
  return !formState.username || !formState.password
})

const onSubmit = async (e: any) => {
  const result = await login(formState)
  if (result.code === 0) {
    localStorage.setItem(ELocalStorageKey.Token, result.data.access_token)
    localStorage.setItem(ELocalStorageKey.WorkspaceId, result.data.workspace_id)
    localStorage.setItem(ELocalStorageKey.Username, result.data.username)
    localStorage.setItem(ELocalStorageKey.UserId, result.data.user_id)
    localStorage.setItem(ELocalStorageKey.Flag, EUserType.Web.toString())
    root.$router.push(ERouterName.MEMBERS)
  } else {
    message.error(result.message)
  }
}

</script>

<style lang="scss" scoped>
@import '/@/styles/index.scss';
.login {
  background-color: $dark-highlight;
  height: 100vh;
}
</style>
