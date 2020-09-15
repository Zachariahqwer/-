<template>
  <div id="box">
  	<div id="h1">
  		<h1><a href="#/Body">人事管理系统</a>-><h5>员工管理入口</h5></h1>
  	</div>
    <hr>

    <div id="Per_1">
      <!-- 头部查询与新建 -->
      <el-row class="table-grid-content">
        <!-- <el-col :span="18" class="grid">
          <el-input v-model="input"  placeholder="可以按照部门编号,名称,类型进行查询"></el-input>
        </el-col> -->
        <el-col :span="3" class="grid" :gutter="1">
          <el-button type="primary" @click="addPersons()">员工信息录入</el-button>
        </el-col>
        <el-col :span="3" class="grid" :gutter="1">
          <el-button type="primary" @click="getPers()">员工信息</el-button>
        </el-col>
        <el-col :span="3" class="grid" :gutter="1">
          <el-button type="primary" @click="getShiyong()">试用期员工信息</el-button>
        </el-col>
      </el-row>

      <!-- 部门调动界面 -->
      <el-dialog :visible.sync="moveShow">
        <el-form :model="DeptDataF" label-width="130px" >
          <el-form-item label="原部门编号:" >
            <el-input v-model="DeptDataF.pdeptno" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="原部门名称:" >
            <el-input v-model="DeptDataF.pdep" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="现部门编号:" >
            <el-input v-model="DeptDataF.nowDeptno" ></el-input>
          </el-form-item>
          <el-form-item label="现部门名称:" >
            <el-input v-model="DeptDataF.nowDept" ></el-input>
          </el-form-item>
          <el-form-item label="员工编号:" >
            <el-input v-model="DeptDataF.pno" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="员工姓名:" >
            <el-input v-model="DeptDataF.pname" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="员工性别:" >
            <el-input v-model="DeptDataF.psex" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="用工形式:" >
            <el-input v-model="DeptDataF.pyongg" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="是否使用:" >
            <el-input v-model="DeptDataF.pshiyong" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="部门调动类型:" >
            <el-select v-model="DeptDataF.bdtype" placeholder="请选择调转类型">
              <el-option label="主动调动" value="主动调动"></el-option>
              <el-option label="被动调动" value="被动调动"></el-option>
              <el-option label="数据错误" value="数据错误"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeM()">取消</el-button>
          <el-button type="primary" @click="moveD()">确定</el-button>
        </div>
      </el-dialog>

      <!-- 岗位调动界面 -->
      <el-dialog :visible.sync="moveShowJob">
        <el-form :model="JobDataF" label-width="130px" >
          <el-form-item label="原岗位编号:" >
            <el-input v-model="JobDataF.pjobno" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="原岗位名称:" >
            <el-input v-model="JobDataF.pjob" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="现岗位编号:" >
            <el-input v-model="JobDataF.nowJobjno" ></el-input>
          </el-form-item>
          <el-form-item label="现岗位名称:" >
            <el-input v-model="JobDataF.nowJob" ></el-input>
          </el-form-item>
          <el-form-item label="员工编号:" >
            <el-input v-model="JobDataF.pno" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="员工姓名:" >
            <el-input v-model="JobDataF.pname" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="员工性别:" >
            <el-input v-model="JobDataF.psex" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="用工形式:" >
            <el-input v-model="JobDataF.pyongg" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="是否使用:" >
            <el-input v-model="JobDataF.pshiyong" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="调动类型:" >
            <el-select v-model="JobDataF.btype" placeholder="请选择调转类型">
              <el-option label="升职" value="升职"></el-option>
              <el-option label="降职" value="降职"></el-option>
              <el-option label="数据录入错误" value="数据录入错误"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeJ()">取消</el-button>
          <el-button type="primary" @click="moveJ()">确定</el-button>
        </div>
      </el-dialog>

      <!-- 员工离职界面 -->
      <el-dialog :visible.sync="deparShow">
        <el-form :model="deparData" label-width="130px" >
          <el-form-item label="部门编号:" >
            <el-input v-model="deparData.pdeptno" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="部门名称:" >
            <el-input v-model="deparData.pdep" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="岗位编号:" >
            <el-input v-model="deparData.pjobno" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="岗位名称:" >
            <el-input v-model="deparData.pjob" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="员工编号:" >
            <el-input v-model="deparData.pno" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="员工姓名:" >
            <el-input v-model="deparData.pname" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="员工性别:" >
            <el-input v-model="deparData.psex" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="用工形式:" >
            <el-input v-model="deparData.pyongg" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="是否在试用:" >
            <el-input v-model="deparData.pshiyong" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="是否离职:" >
            <el-input v-model="deparData.lizhi" ></el-input>
          </el-form-item>
          <el-form-item label="离职日期:" >
            <el-date-picker type="date" placeholder="选择日期" v-model="deparData.ldate" style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item label="离职类型:" >
            <el-select v-model="deparData.ltype" placeholder="请选择离职类型">
              <el-option label="主动辞职" value="主动辞职"></el-option>
              <el-option label="辞退" value="辞退"></el-option>
              <el-option label="退休" value="退休"></el-option>
              <el-option label="开除" value="开除"></el-option>
              <el-option label="试用期未通过" value="试用期未通过"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeL()">取消</el-button>
          <el-button type="primary" @click="sendL()">确定</el-button>
        </div>
      </el-dialog>

      <!-- 展示员工 -->
      <el-table
        :data="PersData"
        style="width: 100%">
        <!-- 通过设置 type="expand"可以开启展开行功能 -->
        <el-table-column type="expand">
          <template slot-scope="props">
            <el-form label-position="left" inline class="demo-table-expand">
              <el-form-item label="员工编号:">
                <span>{{props.row.pno}}</span>
              </el-form-item>
              <el-form-item label="员工姓名:">
                <span>{{props.row.pname}}</span>
              </el-form-item>
              <el-form-item label="员工性别:">
                <span>{{props.row.psex}}</span>
              </el-form-item>
              <el-form-item label="出生日期:">
                <span>{{props.row.pbirthday}}</span>
              </el-form-item>
              <el-form-item label="身份证号:">
                <span>{{props.row.pidnum}}</span>
              </el-form-item>
              <el-form-item label="部门编号:">
                <span>{{props.row.pdeptno}}</span>
              </el-form-item>
              <el-form-item label="部门:">
                <span>{{props.row.pdep}}</span>
              </el-form-item>
              <el-form-item label="岗位编号:">
                <span>{{props.row.pjobno}}</span>
              </el-form-item>
              <el-form-item label="岗位:">
                <span>{{props.row.pjob}}</span>
              </el-form-item>
              <el-form-item label="入职日期:">
                <span>{{props.row.pjoindate}}</span>
              </el-form-item>
              <el-form-item label="参加工作日期:">
                <span>{{props.row.pjobdate}}</span>
              </el-form-item>
              <el-form-item label="用工形式:">
                <span>{{props.row.pyongg}}</span>
              </el-form-item>
              <el-form-item label="人员来源:">
                <span>{{props.row.prlaiyuan}}</span>
              </el-form-item>
              <el-form-item label="政治面貌:">
                <span>{{props.row.pzhenzhi}}</span>
              </el-form-item>
              <el-form-item label="籍贯:">
                <span>{{props.row.pnspace}}</span>
              </el-form-item>
              <el-form-item label="联系电话:">
                <span>{{props.row.ptel}}</span>
              </el-form-item>
              <el-form-item label="电子邮件:">
                <span>{{props.row.pemail}}</span>
              </el-form-item>
              <el-form-item label="婚姻状况:">
                <span>{{props.row.pmar}}</span>
              </el-form-item>
              <el-form-item label="最高学历:">
                <span>{{props.row.phighl}}</span>
              </el-form-item>
              <el-form-item label="最高学位:">
                <span>{{props.row.phighd}}</span>
              </el-form-item>
              <el-form-item label="毕业院校:">
                <span>{{props.row.plearnp}}</span>
              </el-form-item>
              <el-form-item label="毕业日期:">
                <span>{{props.row.pgdate}}</span>
              </el-form-item>
              <el-form-item label="是否在试用期:">
                <span>{{props.row.pshiyong}}</span>
              </el-form-item>
              <el-form-item label="试用开始日期:">
                <span>{{props.row.pbshidate}}</span>
              </el-form-item>
              <el-form-item label="试用结束日期:">
                <span>{{props.row.poshidate}}</span>
              </el-form-item>
            </el-form>
          </template>
        </el-table-column>
        <el-table-column
          label="员工编号"
          prop="pno">
        </el-table-column>
        <el-table-column
          label="员工姓名"
          prop="pname">
        </el-table-column>
        <el-table-column
          label="员工性别"
          prop="psex">
        </el-table-column>
        <el-table-column
          label="部门编号"
          prop="pdeptno">
        </el-table-column>
        <el-table-column
          label="部门"
          prop="pdep">
        </el-table-column>
        <el-table-column
          label="岗位编号"
          prop="pjobno">
        </el-table-column>
        <el-table-column
          label="岗位"
          prop="pjob">
        </el-table-column>
        <el-table-column
          label="用工形式"
          prop="pyongg">
        </el-table-column>
        <el-table-column
          label="入职日期"
          prop="pjoindate">
        </el-table-column>
        <el-table-column
          label="是否在试用期"
          prop="pshiyong">
        </el-table-column>
        <el-table-column
          label="试用开始日期"
          prop="pbshidate">
        </el-table-column>
        <el-table-column
          label="试用结束日期"
          prop="poshidate">
        </el-table-column>
        <el-table-column label="操作" fixed="right" width="400px">
          <template slot-scope="scope">
              <el-button type="primary" @click="DeptDiao(scope.$index,scope.row)">部门调动</el-button>
              <el-button type="primary" @click="JobDiao(scope.$index,scope.row)">岗位调动</el-button>
              <el-button type="danger"  @click="departure(scope.$index,scope.row)">离职/转正</el-button>
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

      <!-- 展示试用期员工信息 -->
      <el-dialog :visible.sync="showShiY">
        <el-table
          :data="ShiYongData"
          style="width: 100%">
          <!-- 通过设置 type="expand"可以开启展开行功能 -->
          <el-table-column type="expand">
            <template slot-scope="props">
              <el-form label-position="left" inline class="demo-table-expand">
                <el-form-item label="员工编号:">
                  <span>{{props.row.pno}}</span>
                </el-form-item>
                <el-form-item label="员工姓名:">
                  <span>{{props.row.pname}}</span>
                </el-form-item>
                <el-form-item label="员工性别:">
                  <span>{{props.row.psex}}</span>
                </el-form-item>
                <el-form-item label="出生日期:">
                  <span>{{props.row.pbirthday}}</span>
                </el-form-item>
                <el-form-item label="身份证号:">
                  <span>{{props.row.pidnum}}</span>
                </el-form-item>
                <el-form-item label="部门编号:">
                  <span>{{props.row.pdeptno}}</span>
                </el-form-item>
                <el-form-item label="部门:">
                  <span>{{props.row.pdep}}</span>
                </el-form-item>
                <el-form-item label="岗位编号:">
                  <span>{{props.row.pjobno}}</span>
                </el-form-item>
                <el-form-item label="岗位:">
                  <span>{{props.row.pjob}}</span>
                </el-form-item>
                <el-form-item label="入职日期:">
                  <span>{{props.row.pjoindate}}</span>
                </el-form-item>
                <el-form-item label="参加工作日期:">
                  <span>{{props.row.pjobdate}}</span>
                </el-form-item>
                <el-form-item label="用工形式:">
                  <span>{{props.row.pyongg}}</span>
                </el-form-item>
                <el-form-item label="人员来源:">
                  <span>{{props.row.prlaiyuan}}</span>
                </el-form-item>
                <el-form-item label="政治面貌:">
                  <span>{{props.row.pzhenzhi}}</span>
                </el-form-item>
                <el-form-item label="籍贯:">
                  <span>{{props.row.pnspace}}</span>
                </el-form-item>
                <el-form-item label="联系电话:">
                  <span>{{props.row.ptel}}</span>
                </el-form-item>
                <el-form-item label="电子邮件:">
                  <span>{{props.row.pemail}}</span>
                </el-form-item>
                <el-form-item label="婚姻状况:">
                  <span>{{props.row.pmar}}</span>
                </el-form-item>
                <el-form-item label="最高学历:">
                  <span>{{props.row.phighl}}</span>
                </el-form-item>
                <el-form-item label="最高学位:">
                  <span>{{props.row.phighd}}</span>
                </el-form-item>
                <el-form-item label="毕业院校:">
                  <span>{{props.row.plearnp}}</span>
                </el-form-item>
                <el-form-item label="毕业日期:">
                  <span>{{props.row.pgdate}}</span>
                </el-form-item>
                <el-form-item label="是否在试用期:">
                  <span>{{props.row.pshiyong}}</span>
                </el-form-item>
                <el-form-item label="试用开始日期:">
                  <span>{{props.row.pbshidate}}</span>
                </el-form-item>
                <el-form-item label="试用结束日期:">
                  <span>{{props.row.poshidate}}</span>
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column
            label="员工编号"
            prop="pno">
          </el-table-column>
          <el-table-column
            label="员工姓名"
            prop="pname">
          </el-table-column>
          <el-table-column
            label="员工性别"
            prop="psex">
          </el-table-column>
          <el-table-column
            label="部门"
            prop="pdep">
          </el-table-column>
          <el-table-column
            label="岗位"
            prop="pjob">
          </el-table-column>
          <el-table-column
            label="用工形式"
            prop="pyongg">
          </el-table-column>
          <el-table-column
            label="入职日期"
            prop="pjoindate">
          </el-table-column>
          <el-table-column
            label="是否在试用期"
            prop="pshiyong">
          </el-table-column>
          <el-table-column
            label="试用开始日期"
            prop="pbshidate">
          </el-table-column>
          <el-table-column
            label="试用结束日期"
            prop="poshidate">
          </el-table-column>
        </el-table>
        <!-- 显示分页 -->
        <el-pagination
          background
          :page-size="sizeS"
          :current-page="currentPageS"
          @current-change="handleCurrentChangeS"
          layout="prev, pager, next"
          :total="totalCountS">
        </el-pagination>
      </el-dialog>

      <!-- 录入员工信息 -->
      <el-dialog :visible.sync="isAddPers">
        <el-form :model="addPer" :rules="rules" ref="addPer" class="demo-ruleForm" label-width="130px">
          <el-form-item label="员工号:" prop="pno" >
            <el-input v-model="addPer.pno" ></el-input>
          </el-form-item>

          <el-form-item label="员工姓名:" prop="pname">
            <el-input v-model="addPer.pname"></el-input>
          </el-form-item>

          <el-form-item label="员工性别:" prop="psex">
            <el-select v-model="addPer.psex" placeholder="请选择员工的性别">
              <el-option label="男" value="男"></el-option>
              <el-option label="女" value="女"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="出生日期:" prop="pbirthday">
            <el-date-picker type="date" placeholder="选择日期" v-model="addPer.pbirthday" style="width: 100%;"></el-date-picker>
          </el-form-item>

          <el-form-item label="身份证号:" prop="pidnum">
            <el-input v-model="addPer.pidnum"></el-input>
          </el-form-item>

          <el-form-item label="部门编号:" prop="pdeptno">
            <el-input v-model="addPer.pdeptno"></el-input>
          </el-form-item>

          <el-form-item label="部门:" prop="pdep">
            <el-input v-model="addPer.pdep"></el-input>
          </el-form-item>

          <el-form-item label="岗位编号:" prop="pjobno">
            <el-input v-model="addPer.pjobno"></el-input>
          </el-form-item>

          <el-form-item label="岗位:" prop="pjob">
            <el-input v-model="addPer.pjob"></el-input>
          </el-form-item>

          <el-form-item label="入职日期:" prop="pjoindate">
            <el-date-picker type="date" placeholder="选择日期" v-model="addPer.pjoindate" style="width: 100%;"></el-date-picker>
          </el-form-item>

          <el-form-item label="参加工作日期:" prop="pjobdate" >
            <el-date-picker type="date" placeholder="选择日期" v-model="addPer.pjobdate" style="width: 100%;"></el-date-picker>
          </el-form-item>

          <el-form-item label="用工形式:" prop="pyongg">
            <el-select v-model="addPer.pyongg" placeholder="请选择用工形式">
              <el-option label="正式员工" value="正式员工"></el-option>
              <el-option label="临时员工" value="临时员工"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="人员来源:" prop="prlaiyuan">
            <el-select v-model="addPer.prlaiyuan" placeholder="请选择人员来源">
              <el-option label="校园招聘" value="校园招聘"></el-option>
              <el-option label="社会招聘" value="社会招聘"></el-option>
              <el-option label="其他" value="其他"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="政治面貌:">
            <el-select v-model="addPer.pzhenzhi" placeholder="请选择政治面貌">
              <el-option label="党员" value="党员"></el-option>
              <el-option label="预备党员" value="预备党员"></el-option>
              <el-option label="团员" value="团员"></el-option>
              <el-option label="其他" value="其他"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="籍贯:">
            <el-input v-model="addPer.pnspace"></el-input>
          </el-form-item>

          <el-form-item label="联系电话:">
            <el-input v-model="addPer.ptel"></el-input>
          </el-form-item>

          <el-form-item label="电子邮件:">
            <el-input v-model="addPer.pemail"></el-input>
          </el-form-item>

          <el-form-item label="婚姻状况:">
            <el-select v-model="addPer.pmar" placeholder="请选择婚姻状况">
              <el-option label="未婚" value="未婚"></el-option>
              <el-option label="已婚" value="已婚"></el-option>
              <el-option label="丧偶" value="丧偶"></el-option>
              <el-option label="离婚" value="离婚"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="最高学历:">
            <el-select v-model="addPer.phighl" placeholder="请选择最高学历">
              <el-option label="高中及以下" value="高中及以下"></el-option>
              <el-option label="大专" value="大专"></el-option>
              <el-option label="本科" value="本科"></el-option>
              <el-option label="研究生" value="研究生"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="最高学位:">
            <el-select v-model="addPer.phighd" placeholder="请选择最高学位">
              <el-option label="无学位" value="无学位"></el-option>
              <el-option label="学士" value="学士"></el-option>
              <el-option label="双学士" value="双学士"></el-option>
              <el-option label="硕士" value="硕士"></el-option>
              <el-option label="博士" value="博士"></el-option>
              <el-option label="博士后" value="博士后"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="毕业院校:">
            <el-input v-model="addPer.plearnp"></el-input>
          </el-form-item>

          <el-form-item label="毕业日期:">
            <el-date-picker type="date" placeholder="选择日期" v-model="addPer.pgdate" style="width: 100%;"></el-date-picker>
          </el-form-item>

          <el-form-item label="是否在试用期:" prop="pshiyong">
            <el-select v-model="addPer.pshiyong" placeholder="请选择是否为试用期">
              <el-option label="是" value="是"></el-option>
              <el-option label="否" value="否"></el-option>
            </el-select>
          </el-form-item>

          <el-form-item label="试用开始日期:" prop="pbshidate">
            <el-date-picker type="date" placeholder="选择日期" v-model="addPer.pbshidate" style="width: 100%;"></el-date-picker>
          </el-form-item>

          <el-form-item label="试用结束日期:" prop="poshidate">
            <el-date-picker type="date" placeholder="选择日期" v-model="addPer.poshidate" style="width: 100%;"></el-date-picker>
          </el-form-item>
        </el-form>
        <div>
          <el-button @click="closeP()">取消</el-button>
          <el-button type="primary" @click="newP()">确定</el-button>
        </div>
      </el-dialog>
    </div>

  </div>
</template>

<script>
  export default{
    name:'Per',
    data(){
      return{
        deparShow:false,    // 离职界面
        moveShow:false,     // 部门调动界面
        moveShowJob:false,  // 岗位调动界面
        showShiY:false,   // 展示试用期员工信息
        deparData:[],      // 离职时存储数据
        DeptDataF:[],      // 部门调动时存储数据
        JobDataF:[],       // 岗位调动时存储数据
        ShiYongData:[],   // 试用期的员工数据
        isAddPers:false,
        PersData:[],     // 员工数据
        totalCount: 0,  // 总记录数
        currentPage:1,   // 当前页
        size:5,         // 每页的数据数量
        // 查询试用期时的分页
        sizeS:5,
        currentPageS:1,
        totalCountS:0,

        // 新建录入信息
        addPer : {
          pno:'',
          pname:'',
          psex:'',
          pbirthday:'',
          pidnum:'',
          pdeptno:'',
          pdep:'',
          pjobno:'',
          pjob:'',
          pjoindate:'',
          pjobdate:'',
          pyongg:'',
          prlaiyuan:'',
          pzhenzhi:'',
          pnspace:'',
          ptel:'',
          pemail:'',
          pmar:'',
          phighl:'',
          phighd:'',
          plearnp:'',
          pgdate:'',
          pshiyong:'',
          pbshidate:'',
          poshidate:''
        },
        rules:{
          pno:[
            {required: true, message: '请输入员工编号', trigger: 'blur'},
            {min: 1, max: 8, message: '长度在 1 到 5 个字符', trigger: 'blur'}
          ],
          pname:[
            {required: true, message: '请输入员工名称', trigger: 'blur'}
          ],
          psex:[
            {required: true, message: '请选择员工的性别', trigger: 'change'}
          ],
          pbirthday:[
            {required: true, message: '请选择出生日期', trigger: 'change'}
          ],
          pidnum:[
            {required: true, message: '请输入员工身份证号', trigger: 'blur'}
          ],
          pdeptno:[
            {required: true, message: '请输入员工所属部门编号', trigger: 'blur'}
          ],
          pdep:[
            {required: true, message: '请输入员工所属部门', trigger: 'blur'}
          ],
          pjobno:[
            {required: true, message: '请输入员工所在岗位编号', trigger: 'blur'}
          ],
          pjob:[
            {required: true, message: '请输入员工所在岗位', trigger: 'blur'}
          ],
          pjoindate:[
            {required: true, message: '请输入员工入职日期', trigger: 'change'}
          ],
          pjobdate:[
            {required: true, message: '请输入员工参加工作日期', trigger: 'change'}
          ],
          pyongg:[
            {required: true, message: '请选择用工形式', trigger: 'change'}
          ],
          prlaiyuan:[
            {required: true, message: '请选择人员来源', trigger: 'change'}
          ],
          pshiyong:[
            {required: true, message: '请选择试用期', trigger: 'change'}
          ],
          pbshidate:[
            {required: true, message: '请选择试用期开始日期', trigger: 'change'}
          ],
          poshidate:[
            {required: true, message: '请选择试用期结束日期', trigger: 'change'}
          ],
        }

      }
    },

    // 钩子函数，载入后
    mounted(){
      this.getPers()
    },

    methods:{
      addPersons(){
        this.isAddPers = true
      },

      // 离职
      departure(index,row){
        this.deparShow = true
        this.deparData = {
          pdeptno:row.pdeptno,
          pdep:row.pdep,
          pjobno:row.pjobno,
          pjob:row.pjob,
          pno:row.pno,
          pname:row.pname,
          psex:row.psex,
          pyongg:row.pyongg,
          pshiyong:row.pshiyong,
          lizhi:this.deparData.lizhi,
          ldate:this.deparData.ldate,
          ltype:this.deparData.ltype,
        }
      },
      // 确定离职操作
      sendL(){
        if(this.deparData.lizhi == undefined){
          alert("不能为空")
        }if(this.deparData.ldate == undefined){
          alert("不能为空")
        }if(this.deparData.ltype == undefined){
          alert("不能为空")
        }else{
          var deparDatas = new URLSearchParams()
          var ldate1 = this.deparData.ldate
          var ldate2 = this.formatDate(ldate1)
          deparDatas.append("pdeptno",this.deparData.pdeptno)
          deparDatas.append("pdep",this.deparData.pdep)
          deparDatas.append("pjobno",this.deparData.pjobno)
          deparDatas.append("pjob",this.deparData.pjob)
          deparDatas.append("pno",this.deparData.pno)
          deparDatas.append("pname",this.deparData.pname)
          deparDatas.append("psex",this.deparData.psex)
          deparDatas.append("pyongg",this.deparData.pyongg)
          deparDatas.append("pshiyong",this.deparData.pshiyong)
          deparDatas.append("lizhi",this.deparData.lizhi)
          deparDatas.append("ldate",ldate2)
          deparDatas.append("ltype",this.deparData.ltype)
          this.$axios.post('/PerServlet?method=dePar',deparDatas).then((response)=>{
          console.log("修改岗位返回的结果：",response)
            if(response.status == 200){
              var depar = response.data
              console.log(depar)
              this.$message({
                message: '离职成功',
                type: 'success'
              });
              this.getPers()
            }else{
              alert("离职失败的原因："+response.data.message)
            }
          }).catch((error)=>{
            console.log("错误原因："+error)
          })
        }
        this.deparShow = false
      },

      // 取消离职操作
      closeL(){
        this.deparShow = false
      },

      // 岗位调动
      JobDiao($index,row){
        this.moveShowJob = true
        this.JobDataF = {
          pjobno:row.pjobno,
          pjob:row.pjob,
          nowJobjno:this.JobDataF.nowJobjno,
          nowJob:this.JobDataF.nowJob,
          pno:row.pno,
          pname:row.pname,
          psex:row.psex,
          pyongg:row.pyongg,
          pshiyong:row.pshiyong,
          btype:this.JobDataF.btype,
        }
      },

      // 确定岗位调动
      moveJ(){
        console.log(this.JobDataF.nowJobjno)
        if(this.JobDataF.nowJobjno == undefined){
          alert("不能为空")
        }if(this.JobDataF.nowJob == undefined){
          alert("不能为空")
        }if(this.JobDataF.btype == undefined){
          alert("不能为空")
        }else{
          var moveJobDatas = new URLSearchParams()
          moveJobDatas.append("pjobno",this.JobDataF.pjobno)
          moveJobDatas.append("pjob",this.JobDataF.pjob)
          moveJobDatas.append("nowJobjno",this.JobDataF.nowJobjno)
          moveJobDatas.append("nowJob",this.JobDataF.nowJob)
          moveJobDatas.append("pno",this.JobDataF.pno)
          moveJobDatas.append("pname",this.JobDataF.pname)
          moveJobDatas.append("psex",this.JobDataF.psex)
          moveJobDatas.append("pyongg",this.JobDataF.pyongg)
          moveJobDatas.append("pshiyong",this.JobDataF.pshiyong)
          moveJobDatas.append("btype",this.JobDataF.btype)
          this.$axios.post('/PerServlet?method=moveJob',moveJobDatas).then((response)=>{
            console.log("修改岗位返回的结果：",response)
              if(response.status == 200){
                this.$message({
                  message: '调动成功',
                  type: 'success'
                });
                this.getPers()
              }else{
                alert("修改岗位失败的原因："+response.data.message)
              }
            }).catch((error)=>{
              console.log("错误原因："+error)
            })
          }
          this.moveShowJob = false
      },

      // 取消岗位调动
      closeJ(){
        this.moveShowJob = false
      },

      // 部门调动
      DeptDiao(index,row){
        this.moveShow = true
        this.DeptDataF = {
          pdeptno:row.pdeptno,
          pdep:row.pdep,
          nowDeptno:this.DeptDataF.nowDeptno,
          nowDept:this.DeptDataF.nowDept,
          pno:row.pno,
          pname:row.pname,
          psex:row.psex,
          pyongg:row.pyongg,
          pshiyong:row.pshiyong,
          bdtype:this.DeptDataF.bdtype,
        }
      },

      // 确定调动
      moveD(){
        console.log(this.DeptDataF.nowDeptno)
        if(this.DeptDataF.nowDeptno == undefined){
          alert("不能为空")
        }if(this.DeptDataF.nowDept == undefined){
          alert("不能为空")
        }if(this.DeptDataF.bdtype == undefined){
          alert("不能为空")
        }else{
          var moveDeptDatas = new URLSearchParams()
          moveDeptDatas.append("pdeptno",this.DeptDataF.pdeptno)
          moveDeptDatas.append("pdep",this.DeptDataF.pdep)
          moveDeptDatas.append("nowDeptno",this.DeptDataF.nowDeptno)
          moveDeptDatas.append("nowDept",this.DeptDataF.nowDept)
          moveDeptDatas.append("pno",this.DeptDataF.pno)
          moveDeptDatas.append("pname",this.DeptDataF.pname)
          moveDeptDatas.append("psex",this.DeptDataF.psex)
          moveDeptDatas.append("pyongg",this.DeptDataF.pyongg)
          moveDeptDatas.append("pshiyong",this.DeptDataF.pshiyong)
          moveDeptDatas.append("bdtype",this.DeptDataF.bdtype)
          this.$axios.post('/PerServlet?method=moveDept',moveDeptDatas).then((response)=>{
          console.log("修改岗位返回的结果：",response)
            if(response.status == 200){
              var move = response.data
              console.log(move)
              this.$message({
                message: '调动成功',
                type: 'success'
              });
              this.getPers()
            }else{
              alert("修改岗位失败的原因："+response.data.message)
            }
          }).catch((error)=>{
            console.log("错误原因："+error)
          })
        }
        this.moveShow = false
      },

      // 取消调动
      closeM(){
        this.moveShow = false
      },

      // 确认录入
      newP(){
        if(this.addPer.pno == ''){
          // alert("员工号不能为空")
        }else if(this.addPer.pname == ''){
          // alert("姓名不能为空")
        }else if(this.addPer.psex == ''){
          // alert("性别不能为空")
        }else if(this.addPer.pbirthday == ''){
          // alert("出生日期不能为空")
        }else if(this.addPer.pidnum == ''){
          // alert("身份证号不能为空")
        }else if(this.addPer.pdeptno == ''){
          // alert("所属部门不能为空")
        }else if(this.addPer.pdep == ''){
          // alert("所属部门不能为空")
        }else if(this.addPer.pjobno == ''){
          // alert("工作岗位不能为空")
        }else if(this.addPer.pjob == ''){
          // alert("工作岗位不能为空")
        }else if(this.addPer.pjoindate == ''){
          // alert("入职日期不能为空")
        }else if(this.addPer.pjobdate == ''){
          // alert("参加工作日期不能为空")
        }else if(this.addPer.pyongg == ''){
          // alert("用工形式不能为空")
        }else if(this.addPer.prlaiyuan == ''){
          // alert("人员来源不能为空")
        }else if(this.addPer.pshiyong == ''){
          // alert("试用期信息不能为空")
        }else if(this.addPer.pbshidate == ''){
          // alert("试用期开始日期不能为空")
        }else if(this.addPer.poshidate == ''){
          // alert("试用期结束日期不能为空")
        }else{
          // URLSearchParams接口定义了处理URL的查询字符串方法
          var addPersons = new URLSearchParams()
          var d1 = this.addPer.pbirthday
          var d2 = this.addPer.pjoindate
          var d3 = this.addPer.pjobdate
          var d4 = this.addPer.pgdate
          var d5 = this.addPer.pbshidate
          var d6 = this.addPer.poshidate
          var date1 = this.formatDate(d1)
          var date2 = this.formatDate(d2)
          var date3 = this.formatDate(d3)
          var date4 = this.formatDate(d4)
          var date5 = this.formatDate(d5)
          var date6 = this.formatDate(d6)
          addPersons.append("pno",this.addPer.pno)
          addPersons.append("pname",this.addPer.pname)
          addPersons.append("psex",this.addPer.psex)
          addPersons.append("pbirthday",date1)
          addPersons.append("pidnum",this.addPer.pidnum)
          addPersons.append("pdeptno",this.addPer.pdeptno)
          addPersons.append("pdep",this.addPer.pdep)
          addPersons.append("pjobno",this.addPer.pjobno)
          addPersons.append("pjob",this.addPer.pjob)
          addPersons.append("pjoindate",date2)
          addPersons.append("pjobdate",date3)
          addPersons.append("pyongg",this.addPer.pyongg)
          addPersons.append("prlaiyuan",this.addPer.prlaiyuan)
          addPersons.append("pzhenzhi",this.addPer.pzhenzhi)
          addPersons.append("pnspace",this.addPer.pnspace)
          addPersons.append("ptel",this.addPer.ptel)
          addPersons.append("pemail",this.addPer.pemail)
          addPersons.append("pmar",this.addPer.pmar)
          addPersons.append("phighl",this.addPer.phighl)
          addPersons.append("phighd",this.addPer.phighd)
          addPersons.append("plearnp",this.addPer.plearnp)
          addPersons.append("pgdate",date4)
          addPersons.append("pshiyong",this.addPer.pshiyong)
          addPersons.append("pbshidate",date5)
          addPersons.append("poshidate",date6)
          console.log(addPersons)
          this.$axios.post('/PerServlet?method=entry',addPersons).then((response)=>{
            console.log("新增部门返回的结果：",response)
            if(response.status == 200){
              this.$message({
                message: '新建成功',
                type: 'success'
              });
              this.getPers()
            }else{
              alert("新建部门失败的原因："+response.data.message)
            }
          }).catch((error)=>{
            console.log("新建部门失败的原因："+error)
          })
          this.isAddPers = false;
        }
      },

      // 时间格式化函数
      formatDate(d){
        var year = d.getFullYear();
        var month = d.getMonth()+1;
        var day = d.getDate();
        if(month<10){
          month = "0"+month;
        }
        if(day<10){
          day = "0"+day;
        }
        return (year + "-" + month + "-" + day);
      },

      // 取消录入
      closeP(){
        this.isAddPers = false
      },

      // 载入所有员工数据
      getPers(){
        var addPers = new URLSearchParams()
        addPers.append("currentpage",this.currentPage)
        addPers.append("size",this.size)
        console.log(this.currentPage)
        console.log(this.size)
        this.$axios.post('/PerServlet?method=findAll',addPers).then((response)=>{
          var per = response.data
          console.log(per)
          this.PersData = per.pageData        // 后台岗位数据给前端
          this.totalCount = per.totalCount    // 将后台得到的总数赋值给前端
          console.log("后台部门数据："+this.PersData[0].pname)
        }).catch((error)=>{
          console.log("发生错误的原因：",error)
        })
      },
      // 分页操作
      handleCurrentChange(pageno){
        this.currentPage = pageno
        this.getPers()
      },

      // 试用员工信息
      getShiyong(){
        this.showShiY = true
        var addPers = new URLSearchParams()
        addPers.append("currentPageS",this.currentPageS)
        addPers.append("sizeS",this.sizeS)
        console.log(this.currentPageS)
        console.log(this.sizeS)
        this.$axios.post('/PerServlet?method=findAllByShi',addPers).then((response)=>{
          var shi = response.data
          console.log(shi)
          this.ShiYongData = shi.pageData        // 后台岗位数据给前端
          this.totalCountS = shi.totalCount    // 将后台得到的总数赋值给前端
          console.log("后台部门数据："+this.ShiYongData[0].pname)
        }).catch((error)=>{
          console.log("发生错误的原因：",error)
        })
      },

      // 查看试用期员工的分页操作
      handleCurrentChangeS(pagenum){
        this.currentPageS = pagenum
        this.getShiyong()
      },
    },
  }
</script>

<style scoped>
  #Per_1{
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
  .demo-table-expand {
      font-size: 0;
  }
  .demo-table-expand label {
    width: 90px;
    color: #99a9bf;
  }
  .demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
  }
</style>
