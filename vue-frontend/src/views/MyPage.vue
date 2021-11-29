<template>
  <div class="mypage">
    <h1>This is view MyPage.vue</h1>
    <MyForm formname="This is component MyForm.vue"/>
  </div>
</template>

<script>
// @ is an alias to /src
import MyForm from '@/components/MyForm.vue'

export default {
  name: 'Home',
  components: {
    MyForm
  }
}
</script>
