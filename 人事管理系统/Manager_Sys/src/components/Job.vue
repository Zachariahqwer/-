<template>

  <div id="box">
    <div id="h1">
    	<h1><a href="#/Body">人事管理系统</a>-><h5>岗位管理入口</h5></h1>
    </div>
    <hr>

    <div id="Job_1">

    <!-- 头部查询与新建 -->
      <el-row class="table-grid-content">
        <el-col :span="16" class="grid">
          <el-input v-model="input" placeholder="可以按照岗位编号,名称,类型进行查找"></el-input>
        </el-col>
        <el-col :span="3" class="grid" :gutter="1">
          <el-button type="success" icon="el-icon-search" @click="findBy()">查询岗位</el-button>
        </el-col>
        <el-col :span="2" class="grid" :gutter="15">
          <el-button type="primary" @click="addJobs()">新建岗位</el-button>
        </el-col>
        <el-col :span="2" class="grid" :gutter="15">
          <el-button type="primary" :loading="load" @click="refresh()">刷新</el-button>
        </el-col>
        <el-col>
          <el-radio-group v-model="radio" >
            <el-radio :label="1" >岗位编号</el-radio>
            <el-radio :label="2" >岗位名称</el-radio>
            <el-radio :label="3" >岗位类型</el-radio>
          </el-radio-group>
        </el-col>
      </el-row>

      <!-- 表格显示岗位 -->
      <el-table :data="JobData" :stripe="true" :border="true" width="100%" :header-cell-style="{color:'#000000',fontSize:'20px'}">
        <el-table-column label="岗位编号" prop="jno" ></el-table-column>
        <el-table-column label="岗位名称" prop="jname" ></el-table-column>
        <el-table-column label="岗位类型" prop="jtype" ></el-table-column>
        <el-table-column label="岗位编制" prop="jnum" ></el-table-column>
        <el-table-column label="操作" fixed="right" width="380px">
          <template slot-scope="scope">
            <el-button type="primary" @click="updateJob(scope.$index,scope.row)">修改</el-button>
            <el-button type="danger" @click="deleteJ(scope.$index,scope.row)">删除</el-button>
            <el-button type="success" @click="queryJobPers(scope.$index,scope.row)">查询该岗位下的员工</el-button>
          </template>
        </el-table-column>
      </el-table>

      <!-- 显示分页 -->
      <el-pagination
        background
        :page-size="size"
        :current-page="currentPage"
        @current-change="handleCurrentChange"
        layout="prev, pager, next"
        :total="totalCount">
      </el-pagination>

      <!-- 显示该岗位下的员工的界面 -->
      <el-dialog :visible.sync="showJobPer">
        <el-table :data="JobPerData">
            <el-table-column property="pjob" label="岗位名称" width="150"></el-table-column>
            <el-table-column property="pjobno" label="岗位编号" width="150"></el-table-column>
            <el-table-column property="pno" label="员工编号" width="150"></el-table-column>
            <el-table-column property="pname" label="员工姓名" width="150"></el-table-column>
            <el-table-column property="psex" label="员工性别" width="150"></el-table-column>
            <el-table-column property="pyongg" label="用工形式"></el-table-column>
            <el-table-column property="pshiyong" label="是否试用"></el-table-column>
        </el-table>
        <el-pagination
          background
          :page-size="sizePer"
          :current-page="currentPagePer"
          @current-change="handleCurrentChange1"
          layout="prev, pager, next"
          :total="totalCountPer">
        </el-pagination>
      </el-dialog>

      <!-- 新建岗位操作 -->
      <el-dialog :visible.sync="isAddJobs">
        <el-form :model="addJob" :rules="rules" ref="addJob" label-width="130px" class="demo-ruleForm">
          <el-form-item label="岗位编号:" prop="jno">
            <el-input v-model="addJob.jno"></el-input>
          </el-form-item>

          <el-form-item label="岗位名称:" prop="jname">
            <el-input v-model="addJob.jname"></el-input>
          </el-form-item>

          <el-form-item label="岗位类型:" prop="jtype">
            <el-select v-model="addJob.jtype" placeholder="请选择岗位的类型">
              <el-option label="管理" value="管理"></el-option>
              <el-option label="技术" value="技术"></el-option>
              <el-option label="营销" value="营销"></el-option>
              <el-option label="市场" value="市场"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="岗位编制:" >
            <el-input v-model="addJob.jnum"></el-input>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeNew()">取消</el-button>
          <el-button type="primary" @click="new_job()">确定</el-button>
        </div>
      </el-dialog>

      <!-- 修改岗位操作 -->
      <el-dialog :visible.sync="isModify">
        <el-form :model="updateForm" :rules="rules" ref="addJob" label-width="130px" class="demo-ruleForm">
          <el-form-item label="岗位名称:" prop="jname">
            <el-input v-model="updateForm.jname"></el-input>
          </el-form-item>

          <el-form-item label="岗位类型:" prop="jtype">
            <el-select v-model="updateForm.jtype" >
              <el-option label="管理" value="管理"></el-option>
              <el-option label="技术" value="技术"></el-option>
              <el-option label="营销" value="营销"></el-option>
              <el-option label="市场" value="市场"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="岗位编制:">
            <el-input v-model="updateForm.jnum"></el-input>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeNo()">取消</el-button>
          <el-button type="primary" @click="modify()">确定</el-button>
        </div>
      </el-dialog>

    </div>

  </div>

</template>

<script>
  export default{
    name:'Job',
    data(){
      return{
        showJobPer:false,
        load:false,        // 刷新
        isAddJobs:false,
        isModify:false,
        JobPerData:[],     // 存储该岗位下的员工数据
        radio:1,           // 单选框默认选择
        in_radio:1,       // 单选框的值
        updateForm:[],    // 存放修改
        size:5,           // 每页显示的数量
        currentPage:1,    // 当前页
        totalCount:0,     // 总记录数
        sizePer:5,        // 显示该岗位下的员工的分页
        currentPagePer:1,
        totalCountPer:0,
        input:'',
        JobData:[],       // 岗位数据

        // 新增岗位数据
        addJob:{
          jno:'',
          jname:'',
          jtype:'',
          jnum:''
        },
        rules:{
          jno:[
            {required: true, message: '请输入岗位编号', trigger: 'blur'},
            {min: 1, max: 4, message: '长度在 1 到 5 个字符', trigger: 'blur'}
          ],
          jname:[
            {required: true, message: '请输入部门名称', trigger: 'blur'}
          ],
          jtype:[
            {required: true, message: '请选择部门类型', trigger: 'change'}
          ]
        }
      }
    },

    // 载入后执行钩子函数
    mounted(){
      this.getJobs()
    },

    methods:{
      addJobs(){
        this.isAddJobs = true
      },

      // 查询该岗位下的员工
      queryJobPers(index,row){
        this.showJobPer=true
        var jobName = row.jname
        var jobNo = row.jno
        console.log(jobName)
        console.log(jobNo)
        var jobPerDatas = new URLSearchParams()
        jobPerDatas.append("queryJName",jobName)
        jobPerDatas.append("queryJNo",jobNo)
        jobPerDatas.append("currentPage",this.currentPagePer)
        jobPerDatas.append("size",this.sizePer)
        this.$axios.post('/FindJobServlet?method=queryPer',jobPerDatas).then((res)=>{
          if(res.status == 200){
            this.$message({
              message: '查询成功',
              type: 'success'
            });
            var query = res.data
            this.JobPerData = query.pageData
            this.totalCountPer = query.totalCount
          }else{
            alert("查询失败")
            this.getJobs()
          }
        }).catch((err)=>{
          console.log("发生错误的原因：",err)
        })
      },

      // 岗位下员工的分页
      handleCurrentChange1(pageNum){
        this.currentPage = pageNum
        this.queryJobPers()
      },

      // 刷新
      refresh(){
        this.load = true
        this.getJobs()
      },

      // 条件查询
      findBy(){
        var inp = this.radio
        var addInputs = new URLSearchParams()
        addInputs.append("input",this.input)
        addInputs.append("currentpage",this.currentPage)
        addInputs.append("size",this.size)
        addInputs.append("in_radio",inp)
        this.$axios.post('/FindJobServlet?method=find',addInputs).then((response)=>{
          var find = response.data
          this.JobData = find.pageData
          this.totalCount = find.totalCount    // 将后台得到的总数赋值给前端
        }).catch((error)=>{
          console.log("发生错误的原因：",error)
          alert("请按照规定查询！")
        })
      },

      // 修改数据
      updateJob(index,row){
        this.isModify = true
        this.updateForm = {
          jno:row.jno,
          jname:row.jname,
          jtype:row.jtype,
          jnum:row.jnum
        }
      },

      // 修改操作
      modify(){
        var updateJobs = new URLSearchParams()
        updateJobs.append("jno",this.updateForm.jno)
        updateJobs.append("jname",this.updateForm.jname)
        updateJobs.append("jtype",this.updateForm.jtype)
        updateJobs.append("jnum",this.updateForm.jnum)
        this.$axios.post('JobServlet?method=updateJ',updateJobs).then((response)=>{
          console.log("修改岗位返回的结果：",response)
            if(response.status == 200){
              this.$message({
                message: '修改成功',
                type: 'success'
              });
              this.getJobs()
            }else{
              alert("修改岗位失败的原因："+response.data.message)
            }
          }).catch((error)=>{
            console.log("错误原因："+error)
          })
          this.isModify = false
      },

      // 取消修改
      closeNo(){
        this.isModify = false;
      },

      // 新建岗位
      new_job(){
        if(this.addJob.jno == ""){
          // alert("岗位编号不能为空！")
        }else if(this.addJob.jname == ""){
          // alert("岗位名称不能为空！")
        }else if(this.addJob.jtype == ""){
          // alert("岗位类型不能为空")
        }else{
          // URLSearchParams接口定义了处理URL的查询字符串方法
          var addJobs = new URLSearchParams()
          addJobs.append("jno",this.addJob.jno)
          addJobs.append("jname",this.addJob.jname)
          addJobs.append("jtype",this.addJob.jtype)
          if(this.addJob.jnum == ""){
            this.addJob.jnum = 0
          }
          addJobs.append("jnum",this.addJob.jnum)
          this.$axios.post('/JobServlet?method=addJ',addJobs).then((response)=>{
            if(response.status == 200){
              this.$message({
                message: '新建成功',
                type: 'success'
              });
              this.getJobs()
            }else{
              alert("新建岗位失败的原因："+response.data.message)
            }
          }).catch((error)=>{
            console.log("新建岗位失败的原因："+error)
          })
          this.isAddJobs = false
        }
      },

      // 取消新建
      closeNew(){
        this.isAddJobs = false
      },

      //  获取后端岗位数据
      getJobs(){
        var addpages = new URLSearchParams()
        addpages.append('currentPage',this.currentPage)
        addpages.append('size',this.size)
        this.$axios.post('/FindJobServlet?method=findJobAll',addpages).then((response)=>{
          if(response.status == 200){
            var job =  response.data
            this.JobData = job.pageData
            this.totalCount = job.totalCount
            this.load = false;
          }else{
            alert("失败了")
          }
        }).catch((error)=>{
          console.log("错误的原因："+error)
        })
      },

      // 分页
      handleCurrentChange(pageNum){
        this.currentPage = pageNum
        this.getJobs()
      },

      // 删除岗位数据
      deleteJ(index,row) {
        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        })
        .then(() => {
          this.deletedJob(index,row)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },

      // 删除操作
      deletedJob(index,row){
        var deleJob = new URLSearchParams()
        deleJob.append("id",row.jno)
        deleJob.append("jName",row.jname)
        this.$axios.post('/JobServlet?method=del',deleJob).then((response)=>{
          if(response.status == 200){
            var del = response.data
            if(del == "yes"){
              alert("该部门下有员工，不能删除")
              this.$message.error('删除失败');
              this.getJobs()
            }else{
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
              this.getJobs()
            }
          }else{
            alert("删除失败的原因："+response.data.message)
          }
        }).catch((error)=>{
          console.log("发生错误的原因："+error)
        })
      }
    }
  }
</script>

<style scoped>
  #Job_1{
    padding: 40px;
    width: 1500px;
    margin: 0px auto;
  }
  .table-grid-content {
  		border-radius: 4px;
  		height: 50 px;
  		background: #ebeef5;
  		padding: 10px;
  	}

</style>
