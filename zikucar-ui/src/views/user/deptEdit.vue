<template>
  <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      :v-if="dialogVisible"
      width="30%"
      :append-to-body="true"
      :before-close="handleClose">
    <div>
      <el-form ref="deptForm" :model="deptForm" :rules="rules">
        <el-form-item prop="deptName">
          <el-input v-model="deptForm.deptName" placeholder="请输入岗位名称" prefix-icon="fa fa-dept"></el-input>
        </el-form-item>
        <el-form-item prop="deptCode">
          <el-input v-model="deptForm.deptCode" placeholder="请输入岗位编码" prefix-icon="fa fa-dept"></el-input>
        </el-form-item>
        <el-form-item prop="remark">
          <el-input type="textarea" v-model="deptForm.remark" placeholder="请输入描述"
                    prefix-icon="fa fa-dept"></el-input>
        </el-form-item>
        <el-form-item style="text-align: right;">
          <el-button @click="handleClose">取 消</el-button>
          <el-button @click="submitForm('deptForm')" type="primary">确定
          </el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>
<script>
export default {
  props: {dialogVisible: Boolean, params: Object},
  data() {
    return {
      deptForm: {
        pkId: '',
        deptName: '',
        deptCode: '',
        remark: ''
      },
      title:"部门"+this.params.operation,
      rules: {
        deptName: [
          {required: true, message: '请输入部门名称', trigger: 'blur'},
          {min: 2, message: '最少输入2个字符', trigger: 'blur'}
        ],
        deptCode: [
          {required: true, message: '请输入部门编码', trigger: 'change'}
        ]
      }
    }
  },
  mounted() {
    if (this.params.pkId) {
      this.initDept();
      console.log("dept edit init");
    }

  },
  methods: {
    handleClose() {
      this.$emit("dept-edit-close");
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.edit();
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    initDept() {
      this.http.get(this.api.dept.getById + "/" + this.params.pkId, res => {
        this.deptForm = res.data;
      }, (error) => {
        console.log("查询岗位信息错误-》" + error);
      })
    },
    edit() {
      let url = this.api.dept.add;
      let msg = "添加";
      if (this.params.pkId) {
        url = this.api.dept.update;
        msg = "修改";
      }
      this.http.post(url, this.deptForm, res => {
        if (res.code == 200) {
          this.$message({message: msg + '成功！', type: 'success'});
          this.$emit("dept-edit-close");
          return;
        }
        this.$message({message: msg + '失败！', type: 'error'});
      }, (error) => {
        console.log("查询岗位信息错误-》" + error);
      })
    }
  }
}
</script>
<style>
</style>