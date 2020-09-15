<template>
  <div id="app">
    <!-- <img src="./assets/logo.png">
    <input type="text" v-model="a"/>
    <button @click="f1">测试</button><br /> -->
    <!-- <el-row>
      <el-button>默认按钮</el-button>
      <el-button type="primary">主要按钮</el-button>
      <el-button type="success">成功按钮</el-button>
      <el-button type="info">信息按钮</el-button>
      <el-button type="warning">警告按钮</el-button>
      <el-button type="danger">危险按钮</el-button>
    </el-row> -->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data(){
    return{
      a:'',
    }
  },
  methods:{
    f1(){
      // 解决axios跨域问题，3、修改连接
      var user = this.a
      this.$axios.get("/UserServlet?user="+user)
      .then(res=>{
        console.log(res)   // 返回结果
      })
      .catch(err=>{
        console.log(err)
      })
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* margin-top: 60px; */
}
</style>
