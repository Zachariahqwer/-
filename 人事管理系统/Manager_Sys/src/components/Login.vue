<template>
  <div id="box">
  	<div id="h1">
  		<h1>人事管理系统</h1>
  	</div>
  	<hr />

  	<div id="login_body">

      <el-form :model="LoginData" status-icon :rules="rules" ref="LoginData" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名:" prop="username">
          <el-input type="password" v-model="LoginData.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码:" prop="password">
          <el-input type="password" v-model="LoginData.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="真实姓名:" prop="name">
          <el-input v-model="LoginData.name"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login()">提交</el-button>
        </el-form-item>
      </el-form>

  	</div>
  </div>
</template>

<script>
  export default{
    name:'Login',
    data(){
      return{
        getData:[],
        LoginData:{
          username:"",
          password:"",
          name:""
        },
        rules:{
          username:[
            {required: true, message: '请输入用户名', trigger: 'blur'},
          ],
          password:[
            {required: true, message: '请输入密码', trigger: 'blur'}
          ],
          name:[
            {required: true, message: '请选择真实姓名', trigger: 'blur'}
          ]
        }
      }
    },
    methods:{
      login(){
        // 解决axios跨域问题，3、修改连接
        if(this.LoginData.username == ""){
          this.$message.error('用户名不能为空');
        }if(this.LoginData.password == ""){
          this.$message.error('密码不能为空');
        }if(this.LoginData.name == ""){
          this.$message.error('真实姓名不能为空');
        }else{
          var logindata = new URLSearchParams()
          logindata.append("username",this.LoginData.username)
          logindata.append("password",this.LoginData.password)
          logindata.append("name",this.LoginData.name)
          this.$axios.post('/HrServlet',logindata).then((res)=>{
            var d = res.data
            var user = d.realName
            console.log(user)
            if(d == "登录错误"){
              this.$message.error("登录失败")
            }else{
              this.$message({
                type:"success",
                message:"登录成功",
              });
              this.$router.push("/Body?u="+user)
            }
          }).catch((error)=>{
            console.log("错误原因："+error)
          })
        }

      }
    }
  }
</script>

<style>
  #login_body{
  	padding-top: 40px;
  	line-height: 20px;
  	width: 500px;
  	text-align: center;
  	margin: 0px auto;
  }
</style>
