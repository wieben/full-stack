<template>
  <h1>{{ formname }}</h1>
  <form>
    <label for="valueField">send to server&nbsp;</label>
    <input id="valueField" v-model="value"/>
    <span>&nbsp;</span>
    <button @click="submit">Submit</button>
    <p>received from server:</p>
    <p><b>{{ response }}</b></p>
  </form>
</template>

<script>
import axios from 'axios'

export default {
  name: 'MyForm',
  data() {
    return {
      value: 'some initial value',
      response: undefined
    }
  },
  props: {
    formname: String
  },
  methods: {
    submit() {
      const axiosInstance = axios.create({ baseURL: 'api' })
      const axiosRequestConfig = {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded'
        }
      }
      const promise = axiosInstance.post('endpointforform/callforform', `label=${encodeURIComponent(this.value)}`, axiosRequestConfig)
      let mydata = this.$data
      promise.then(function(axiosResponse) {
        mydata.response = axiosResponse.data.label
      })
    }
  }
}
</script>

<style>
/* style goes here */
</style>
