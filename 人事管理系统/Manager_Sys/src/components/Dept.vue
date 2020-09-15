<template>
  <div id="box">
  	<div id="h1">
  		<h1><a href="#/Body">人事管理系统</a>-><h5>部门管理入口</h5></h1>
  	</div>
  	<hr>

  	<div id="Dept_1">

      <!-- 头部查询与新建 -->
      <el-row class="table-grid-content">
        <el-col :span="16" class="grid">
          <el-input v-model="input"  placeholder="可以按照部门编号,名称,类型进行查询"></el-input>
        </el-col>
        <el-col :span="3" class="grid" :gutter="1">
          <el-button type="success" icon="el-icon-search" @click="findBy()">查询部门</el-button>
        </el-col>
        <el-col :span="2" class="grid" :gutter="15">
          <el-button type="primary" @click="addDepts()">新建部门</el-button>
        </el-col>
        <el-col :span="2" class="grid" :gutter="15">
          <el-button type="primary" :loading="load" @click="refresh()">刷新</el-button>
        </el-col>
        <el-col>
          <el-radio-group v-model="radio" >
            <el-radio :label="1" >部门编号</el-radio>
            <el-radio :label="2" >部门名称</el-radio>
            <el-radio :label="3" >部门类型</el-radio>
          </el-radio-group>
        </el-col>
      </el-row>

      <!-- 表格显示部门 -->
      <el-table :data="Deptdata" :stripe="true" :border="true" width="100%" :header-cell-style="{color:'#000000',fontSize:'20px'}">
        <el-table-column label="部门编号" prop="deptno" width="120px"></el-table-column>
        <el-table-column label="部门名称" prop="dname" width="120px"></el-table-column>
        <el-table-column label="部门类型" prop="dtype" width="120px"></el-table-column>
        <el-table-column label="部门电话" prop="dtel"></el-table-column>
        <el-table-column label="部门传真" prop="demail"></el-table-column>
        <el-table-column label="部门描述" prop="dmiaoshu"></el-table-column>
        <el-table-column label="上级部门" prop="ddescribe"></el-table-column>
        <el-table-column label="成立日期" prop="ddate"></el-table-column>
        <el-table-column label="操作" fixed="right" width="380px">
          <template slot-scope="scope">
            <el-button type="primary" @click="modifyDept(scope.$index,scope.row)">修改</el-button>
            <el-button type="danger" @click="deleteD(scope.$index,scope.row)">删除</el-button>
            <el-button type="success" @click="queryDeptPers(scope.$index,scope.row)">查询该部门下的员工</el-button>
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

      <!-- 新建部门操作 -->
      <!-- visible:新增对话框是否可见，支持.sync修饰符修饰，用isAddDepts控制对话框的显示和隐藏，初始值为false  -->
      <el-dialog :visible.sync="isAddDepts">
        <!-- :rules="rules" 制定规则 -->
        <el-form :model="addForm" :rules="rules" ref="addForm" label-width="120px" class="demo-ruleForm">

          <el-form-item label="部门编号:" prop="deptno">
            <el-input v-model="addForm.deptno"></el-input>
          </el-form-item>

          <el-form-item label="部门名称:" prop="dname">
            <el-input v-model="addForm.dname"></el-input>
          </el-form-item>

          <el-form-item label="部门类型:" prop="dtype">
            <el-select v-model="addForm.dtype" placeholder="请选择部门类型">
              <el-option label="公司" value="公司"></el-option>
              <el-option label="部门" value="部门"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="部门电话:" prop="dtel">
            <el-input v-model="addForm.dtel"></el-input>
          </el-form-item>

          <el-form-item label="部门传真:" >
            <el-input v-model="addForm.demail"></el-input>
          </el-form-item>

          <el-form-item label="部门描述:" >
            <el-input v-model="addForm.dmiaoshu"></el-input>
          </el-form-item>

          <el-form-item label="上级部门:" >
            <el-input v-model="addForm.ddescribe"></el-input>
          </el-form-item>

          <el-form-item label="成立日期:" prop="ddate">
            <el-date-picker type="date" placeholder="选择日期" v-model="addForm.ddate" style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeN()">取消</el-button>
          <el-button type="primary" @click="new_send()">确定</el-button>
        </div>
      </el-dialog>

      <!-- 显示该部门下的员工的界面 -->
      <el-dialog :visible.sync="showDeptPer">
        <el-table :data="DeptPerData">
            <el-table-column property="pdeptno" label="部门编号" width="150"></el-table-column>
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

      <!-- 修改部门界面 -->
      <el-dialog :visible.sync="isModify">
        <el-form :model="updataInfo" :rules="rules" ref="addForm" label-width="130px" class="demo-ruleForm">
          <el-form-item label="部门名称:" prop="dname">
            <el-input v-model="updataInfo.dname"></el-input>
          </el-form-item>
          <el-form-item label="部门类型:" prop="dtype">
            <el-select v-model="updataInfo.dtype">
              <el-option label="公司" value="公司"></el-option>
              <el-option label="部门" value="部门"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="部门电话:" prop="dtel">
            <el-input v-model="updataInfo.dtel"></el-input>
          </el-form-item>
          <el-form-item label="部门传真:">
            <el-input v-model="updataInfo.demail"></el-input>
          </el-form-item>
          <el-form-item label="部门描述:">
            <el-input v-model="updataInfo.dmiaoshu"></el-input>
          </el-form-item>
          <el-form-item label="上级部门:">
            <el-input v-model="updataInfo.ddescribe"></el-input>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeU()">取消</el-button>
          <el-button type="primary" @click="updata()">确定</el-button>
        </div>
      </el-dialog>
  	</div>

  </div>
</template>

<script>

  export default{
    name:"Dept",
    data(){
      return{
        load:false,          // 刷新显示默认值
        showDeptPer:false,  // 显示该部门下的员工的界面
        isAddDepts:false,  // 新建界面的弹框
        isModify:false,    // 修改界面的弹框
        radio:1,           // 单选框默认选择
        in_radio:1,       // 单选框的值
        updataInfo:[],    // 修改
        // addpage:[],
        totalCount: 0,  // 总记录数
        currentPage:1,   // 当前页
        size:5,         // 每页的数据数量
        totalCountPer: 0,  // 总记录数
        currentPagePer:1,   // 当前页
        sizePer:6,         // 每页的数据数量
        input:'',
        Deptdata:[],     // 分页部门数据数组
        DeptPerData:[],  // 部门下的员工

        // 新增部门的存储数据
        addForm:{
          deptno:'',
          dname:'',
          dtype:'',
          dtel:'',
          demail:'',
          dmiaoshu:'',
          ddescribe:'',
          ddate:''
        },
        rules:{
          deptno:[
            {required: true, message: '请输入部门编号', trigger: 'blur'},
            {min: 1, max: 4, message: '长度在 1 到 4 个字符', trigger: 'blur'}
          ],
          dname:[
            {required: true, message: '请输入部门名称', trigger: 'blur'},
          ],
          dtype:[
            {required: true, message: '请选择部门类型', trigger: 'change'},
          ],
          dtel:[
            {required: true, message: '电话不能为空', trigger: 'blur'},
            { message: '长度在为11个字符', trigger: 'blur'}
          ],
          ddate:[
            {type: 'date',required: true, message: '请选择日期', trigger: 'change'},
          ],
        }
      }
    },

    // 载入后
    mounted(){
      this.getDepts()
    },

    methods:{
      addDepts(){
        this.isAddDepts = true
      },

      // 显示当前部门下的员工
      queryDeptPers(index,row){
        this.showDeptPer=true
        var deptName = row.dname
        // console.log(deptName)
        var deptPerDatas = new URLSearchParams()
        deptPerDatas.append("querydname",deptName)
        deptPerDatas.append("currentpage",this.currentPagePer)
        deptPerDatas.append("size",this.sizePer)
        this.$axios.post('/FindServlet?method=queryPer',deptPerDatas).then((res)=>{
          if(res.status == 200){
            this.$message({
              message: '查询成功',
              type: 'success'
            });
            var query = res.data
            console.log(query)
            this.DeptPerData = query.pageData
            this.totalCountPer = query.totalCount
            // console.log("后台部门数据："+this.DeptPerData[0].psex)
          }else{
            alert("查询失败")
            this.getDepts()
          }
        }).catch((err)=>{
          console.log("发生错误的原因：",err)
        })
      },

      // 查询该部门下的员工的分页
      handleCurrentChange1(pageno){
        this.currentPagePer = pageno
        this.queryDeptPers()
      },

      // 刷新界面
      refresh(){
        this.load = true;
        this.getDepts()
      },

      // 查询部门
      findBy(){
        var inp = this.radio
        var addInputs = new URLSearchParams()
        addInputs.append("input",this.input)
        addInputs.append("currentpage",this.currentPage)
        addInputs.append("size",this.size)
        addInputs.append("in_radio",inp)
        console.log(this.inp)
        console.log(this.currentPage)
        console.log(this.size)
        this.$axios.post('/FindServlet?method=findByDno',addInputs).then((response)=>{
          var find = response.data
          console.log(find)
          this.Deptdata = find.pageData
          this.totalCount = find.totalCount    // 将后台得到的总数赋值给前端
          console.log("后台部门数据："+this.Deptdata[0].dname)
        }).catch((error)=>{
          console.log("发生错误的原因：",error)
          alert("请按照规定查询！")
        })

      },

      // 修改部门数据
      modifyDept(index,row){
        this.isModify = true
        this.updataInfo = {
          deptno:row.deptno,
          dname:row.dname,
          dtype:row.dtype,
          dtel:row.dtel,
          demail:row.demail,
          dmiaoshu:row.dmiaoshu,
          ddescribe:row.ddescribe,
          ddate:row.ddate,
        }
      },

      // 更新部门操作
      updata(index,row){
        var updatas = new URLSearchParams()
        console.log(this.updataInfo.dtype)
        if(this.updataInfo.demail == undefined){
          this.updataInfo.demail = "无"
        }
        if(this.updataInfo.dmiaoshu == undefined){
          this.updataInfo.dmiaoshu = "无"
        }
        if(this.updataInfo.ddescribe == undefined){
          this.updataInfo.ddescribe = "无"
        }
        updatas.append("deptno",this.updataInfo.deptno)
        updatas.append("dname",this.updataInfo.dname)
        updatas.append("dtype",this.updataInfo.dtype)
        updatas.append("dtel",this.updataInfo.dtel)
        updatas.append("demail",this.updataInfo.demail)
        updatas.append("dmiaoshu",this.updataInfo.dmiaoshu)
        updatas.append("ddescribe",this.updataInfo.ddescribe)
        updatas.append("ddate",this.updataInfo.ddate)
        this.$axios.post('/DeptServlet?method=updata',updatas).then((response)=>{
          console.log("修改部门返回的结果：",response)
          if(response.status == 200){
            this.$message({
              message: '修改成功',
              type: 'success'
            });
            this.getDepts()
          }else{
            alert("修改部门失败的原因："+response.data.message)
          }
        }).catch((error)=>{
          console.log("错误原因："+error)
        })
        this.isModify = false
      },

      // 取消修改方法
      closeU(){
        this.isModify = false
      },

      // 时间格式化函数
      formatDate(date1){
        var year = date1.getFullYear();
        var month = date1.getMonth()+1;
        var day = date1.getDate();

        if(month<10){
          month = "0"+month;
        }
        if(day<10){
          day = "0"+day;
        }
        return (year + "-" + month + "-" + day);
      },

      // 确认新建方法
      new_send(){
        if(this.addForm.deptno == ''){
          alert("部门编号能为空")
        }else if(this.addForm.dname == ''){
          alert("部门名称能为空")
        }else if(this.addForm.dtype == ''){
          alert("部门类型能为空")
        }else if(this.addForm.dtel == ''){
          alert("部门电话能为空")
        }else if(this.addForm.ddate == ''){
          alert("部门创建日期能为空")
        }else{
          // URLSearchParams接口定义了处理URL的查询字符串方法
          var addDepts = new URLSearchParams()
          var date1 = this.addForm.ddate
          var date2 = this.formatDate(date1)
          addDepts.append("deptno",this.addForm.deptno)
          addDepts.append("dname",this.addForm.dname)
          addDepts.append("dtype",this.addForm.dtype)
          addDepts.append("dtel",this.addForm.dtel)
          addDepts.append("demail",this.addForm.demail)
          addDepts.append("dmiaoshu",this.addForm.dmiaoshu)
          addDepts.append("ddescribe",this.addForm.ddescribe)
          addDepts.append("ddate",date2)

          this.$axios.post('/DeptServlet?method=addDep',addDepts).then((response)=>{
            console.log("新增部门返回的结果：",response)
            if(response.status == 200){
              this.$message({
                message: '添加成功',
                type: 'success'
              });
              this.getDepts()
            }else{
              alert("新建部门失败的原因："+response.data.message)
            }
          }).catch((error)=>{
            console.log("新建部门失败的原因："+error)
          })
          this.isAddDepts = false;
        }

      },

      // 取消新建方法
      closeN(){
        this.isAddDepts = false
      },

      // 获取后台查询的所有数据
      getDepts(){
        var addPages = new URLSearchParams()
        addPages.append("currentpage",this.currentPage)
        addPages.append("size",this.size)
        this.$axios.post('/FindServlet?method=findPage',addPages).then((response)=>{
          if(response.status == 200){
            this.load = false
            var d = response.data
            console.log(d)
            this.Deptdata = d.pageData        // 后台岗位数据给前端
            this.totalCount = d.totalCount    // 将后台得到的总数赋值给前端
            console.log("后台部门数据："+this.Deptdata[0].ddate)
          }else{
            alert("失败了")
          }
        }).catch((error)=>{
          console.log("发生错误的原因：",error)
        })
      },

      // 分页
      handleCurrentChange(pageNum){
        this.currentPage = pageNum
        this.getDepts()
      },

      // 删除数据
      deleteD(index,row) {
        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        })
        .then(() => {
          this.deleteDept(index,row)
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
      },

      // 删除操作
      deleteDept(index,row){
        console.log(row.deptno)
        console.log(row.dname)
        var deteData = new URLSearchParams()
        deteData.append("id",row.deptno)
        deteData.append("dname",row.dname)
        this.$axios.post('/DeptServlet?method=del',deteData).then((response)=>{
          if(response.status == 200){
            var del = response.data
            if(del == "yes"){
              alert("该部门下有员工，不能删除")
              this.$message.error('删除失败');
            }else{
              this.$message({
                type: 'success',
                message: '删除成功!'
              });
              this.getDepts()
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
  #Dept_1{
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
