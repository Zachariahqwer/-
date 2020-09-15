<template>
  <div id="box">
    <div id="h1">
    	<h1><a href="#/Body">人事管理系统</a>-><h5>报表管理入口</h5></h1>
    </div>
    <hr>
    <div id="Bao_1">
      <el-row class="table-grid-content">
        <el-col :span="3" class="grid" :gutter="15">
          <el-button type="success" @click="DeptTable()">部门调动报表</el-button>
        </el-col>
        <el-col :span="2" class="grid" :gutter="15">
          <el-button type="primary" @click="JobTable()">岗位调动报表</el-button>
        </el-col>
        <el-col :span="2" class="grid" :gutter="15">
          <el-button type="primary" @click="Depar()">离职报表</el-button>
        </el-col>
      </el-row>

      <!-- 表格显示部门调动报表 -->
      <!-- <el-table :data="DeptBaoData" :stripe="true" :border="true" width="100%" :header-cell-style="{color:'#000000',fontSize:'20px'}">
        <el-table-column label="原部门编号" prop="bdeptno" width="150px"></el-table-column>
        <el-table-column label="原部门名称" prop="bdept" width="150px"></el-table-column>
        <el-table-column label="现部门编号" prop="nowDeptno" width="150px"></el-table-column>
        <el-table-column label="现部门名称" prop="nowDept"></el-table-column>
        <el-table-column label="员工编号" prop="bpno"></el-table-column>
        <el-table-column label="员工姓名" prop="bpname"></el-table-column>
        <el-table-column label="员工性别" prop="bpsex"></el-table-column>
        <el-table-column label="用工形式" prop="bpyongg"></el-table-column>
        <el-table-column label="是否试用" prop="bpshiyong"></el-table-column>
      </el-table>
      <el-pagination
        background
        :page-size="size"
        :current-page="currentPage"
        @current-change="handleCurrentChange"
        layout="prev, pager, next"
        :total="totalCount">
      </el-pagination> -->
      <router-view></router-view>
    </div>

  </div>
</template>

<script>
  export default{
    name:'Bao',
    // data(){
    //   return {
    //     DeptBaoData:[],
    //     size:5,
    //     currentPage:1,
    //     totalCount:0,
    //   }
    // },

    // 钩子函数，载入后调用
    mounted(){
      this.DeptTable()
    },

    methods:{
      DeptTable(){
        this.$router.push({path:"/Bao/DeptT"})
      },
      // // 查询报表
      // DeptTable(){
      //   var tableData = new URLSearchParams()
      //   tableData.append("currentPage",this.currentPage)
      //   tableData.append("size",this.size)
      //   this.$axios.post('/TableServlet?method=tableDept',tableData).then((res)=>{
      //     if(res.status == 200){
      //       this.$message({
      //         type: 'success',
      //         message: '查询报表成功!'
      //       });
      //       var deptdata = res.data
      //       this.DeptBaoData = deptdata.pageData
      //       this.totalCount = deptdata.totalCount
      //     }else{
      //       this.$message.error('查询失败')
      //     }
      //   }).catch((error)=>{
      //     console.log("错误信息："+error)
      //   })
      // },

      // // 分页操作
      // handleCurrentChange(pagenum){
      //   this.currentPage = pagenum
      //   this.DeptTable()
      // },

      // 查看岗位报表
      JobTable(){
        this.$router.push({path:"/Bao/JobT"})
      },
      Depar(){
        this.$router.push({path:"/Bao/Depar"})
      }
    }
  }
</script>

<style scoped>

  #Bao_1{
    padding: 40px;
    width: 1500px;
    margin: 0px auto;
  }

  .table-grid-content {
  		border-radius: 4px;
  		height: 50px;
  		background: #ebeef5;
  		padding: 10px;
  	}
</style>
