<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="患者姓名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入患者姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者年龄" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入患者年龄"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者身份证号码" prop="code">
        <el-input
          v-model="queryParams.code"
          placeholder="请输入患者身份证号码"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="患者性别" prop="sex">
        <el-select v-model="queryParams.sex" placeholder="请选择患者性别" clearable>
          <el-option
            v-for="dict in dict.type.sys_user_sex"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:archives:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:archives:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:archives:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:archives:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="archivesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="患者编号" align="center" prop="id" />
      <el-table-column label="患者姓名" align="center" prop="name" />
      <el-table-column label="患者年龄" align="center" prop="age" />
      <el-table-column label="患者身份证号码" align="center" prop="code" />
      <el-table-column label="患者性别" align="center" prop="sex">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_user_sex" :value="scope.row.sex"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:archives:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:archives:remove']"
          >删除</el-button>
            <el-button
              type="primary"
              plain
              icon="el-icon-plus"
              size="mini"
              @click="handleMZ(scope.row)"
              v-hasPermi="['system:archives:add']" style="padding:8px 5px"
            >新增门诊信息</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改个人档案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form v-if="title=='添加门诊信息'" ref="form" :model="form" :rules="rulesAc" label-width="80px">
        <el-form-item label="金额" prop="money">
          <el-input v-model="form.money" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="启用日期" prop="enabletime">
          <el-date-picker clearable
                          v-model="form.enabletime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择启用日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="挂失日期" prop="losstime">
          <el-date-picker clearable
                          v-model="form.losstime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择挂失日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="卡作废日期" prop="deadtime">
          <el-date-picker clearable
                          v-model="form.deadtime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择卡作废日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="退卡日期" prop="returntime">
          <el-date-picker clearable
                          v-model="form.returntime"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="请选择退卡日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="门诊卡状态" prop="status">
          <el-select v-model="form.status" placeholder="请选择门诊卡状态">
            <el-option
              v-for="dict in dict.type.outpatient_info_status"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="押金" prop="deposit">
          <el-input v-model="form.deposit" placeholder="请输入押金" />
        </el-form-item>
        <el-form-item label="个人档案编号" prop="personid">
          <el-input v-model="form.personid" disabled placeholder="请输入个人档案编号" />
        </el-form-item>
      </el-form>
      <el-form v-if="title=='添加个人档案'||title=='修改个人档案'" ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="患者姓名" prop="name">
          <el-input v-model="form.name" placeholder="请输入患者姓名" />
        </el-form-item>
        <el-form-item label="患者年龄" prop="age">
          <el-input v-model="form.age" placeholder="请输入患者年龄" />
        </el-form-item>
        <el-form-item label="患者身份证号码" prop="code">
          <el-input v-model="form.code" placeholder="请输入患者身份证号码" />
        </el-form-item>
        <el-form-item label="患者性别">
          <el-radio-group v-model="form.sex">
            <el-radio
              v-for="dict in dict.type.sys_user_sex"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listArchives, getArchives, delArchives, addArchives, updateArchives, addInfo} from "@/api/system/archives";
import info from "@/views/system/info/index.vue";

export default {
  name: "Archives",
  dicts: ['outpatient_info_status','sys_user_sex'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 个人档案表格数据
      archivesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        money: null,
        enabletime: null,
        losstime: null,
        deadtime: null,
        returntime: null,
        status: null,
        deposit: null,
        personid: null,
      },
      // 表单参数
      form: {},
      formDto:{
        info:{},
        wait:{}
      },
      // 表单校验
      rules: {
        id: [
          { required: true, message: "患者编号不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "患者姓名不能为空", trigger: "blur" }
        ],
        age: [
          { required: true, message: "患者年龄不能为空", trigger: "blur" }
        ],
        code: [
          { required: true, message: "患者身份证号码不能为空", trigger: "blur" }
        ],
        sex: [
          { required: true, message: "患者性别不能为空", trigger: "blur" }
        ]
      },
      rulesAc:{
        id: [
          { required: true, message: "门诊卡编号不能为空", trigger: "blur" }
        ],
        money: [
          { required: true, message: "金额不能为空", trigger: "blur" }
        ],
        status: [
          { required: true, message: "门诊卡状态不能为空", trigger: "change" }
        ],
        deposit: [
          { required: true, message: "押金不能为空", trigger: "blur" }
        ],
        personid: [
          { required: true, message: "个人档案编号不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询个人档案列表 */
    getList() {
      this.loading = true;
      listArchives(this.queryParams).then(response => {
        this.archivesList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        money: null,
        enabletime: null,
        losstime: null,
        deadtime: null,
        returntime: null,
        status: null,
        deposit: null,
        personid: null,
        name: null,
        age: null,
        code: null,
        sex: "0"
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加个人档案";
    },
    handleMZ(row) {
      this.reset();
      this.open = true;
      this.title = "添加门诊信息";
      this.form.personid = row.id;
      // this.form.id = row.id;
      this.formDto.wait.id =row.id;
      this.formDto.wait.name = row.name;
      this.formDto.wait.age = row.age;
      this.formDto.wait.code = row.code;
      this.formDto.wait.sex = row.sex;
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getArchives(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改个人档案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateArchives(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            if(this.title == "添加门诊信息"){
              this.formDto.info = this.form;
              console.log(this.formDto)
              addInfo(this.formDto).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
                this.info.getList();
              });
            }else{
              addArchives(this.form).then(response => {
                this.$modal.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              });
            }
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除个人档案编号为"' + ids + '"的数据项？').then(function() {
        return delArchives(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/archives/export', {
        ...this.queryParams
      }, `archives_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
