<template>
  <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      :v-if="dialogVisible"
      width="30%"
      :append-to-body="true"
      :before-close="handleClose">
    <div>
      <el-form ref="positionForm" :model="positionForm" :rules="rules">
        <el-form-item prop="deptId">
          <el-select v-model="positionForm.deptId" placeholder="请选择部门" style="width: 100%">
            <el-option v-for="item in deptOptions"
                       :key="item.deptName" :label="item.deptName" :value="item.pkId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item prop="positionName">
          <el-input v-model="positionForm.positionName" placeholder="请输入岗位名称"></el-input>
        </el-form-item>
        <el-form-item prop="positionCode">
          <el-input v-model="positionForm.positionCode" placeholder="请输入岗位编码" ></el-input>
        </el-form-item>
        <el-form-item prop="remark">
          <el-input type="textarea" v-model="positionForm.remark" placeholder="请输入描述"
                    prefix-icon="fa fa-position"></el-input>
        </el-form-item>
        <el-form-item style="text-align: right;">
          <el-button @click="handleClose">取 消</el-button>
          <el-button @click="submitForm('positionForm')" type="primary">确定
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
      positionForm: {
        pkId: '',
        deptId:"",
        positionName: '',
        positionCode: '',
        remark: ''
      },
      title:"岗位"+this.params.operation,
      deptOptions:[],
      rules: {
        deptId: [
          { required: true, message: '请选择部门', trigger: 'change' }
        ],
        positionName: [
          {required: true, message: '请输入岗位名称', trigger: 'blur'},
          {min: 2, message: '最少输入2个字符', trigger: 'blur'}
        ],
        positionCode: [
          {required: true, message: '请输入岗位编码', trigger: 'change'}
        ]
      }
    }
  },
  mounted() {
    if (this.params.pkId) {
      this.initposition();
      console.log("position edit init");
    }
    this.initDeptList();
  },
  methods: {
    handleClose() {
      this.$emit("position-edit-close");
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
    initposition() {
      this.http.get(this.api.position.getById + "/" + this.params.pkId, res => {
        this.positionForm = res.data;
      }, (error) => {
        console.log("查询岗位信息错误-》" + error);
      })
    },
    initDeptList() {
      this.http.get(this.api.dept.list,res=>{
        this.deptOptions = res.data;
      },(error)=>{
        console.log("查询岗位信息错误-》"+error);
      })
    },
    edit() {
      let url = this.api.position.add;
      let msg = "添加";
      if (this.params.pkId) {
        url = this.api.position.update;
        msg = "修改";
      }
      this.http.post(url, this.positionForm, res => {
        if (res.code == 200) {
          this.$message({message: msg + '成功！', type: 'success'});
          this.$emit("position-edit-close");
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