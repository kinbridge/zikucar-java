<template>
  <div class="register-content">
    <div class="login-panel">
      <div class="register-title">
        <h2 style="color:#fff;margin: 0;">智库汽车后台管理系统用户注册</h2>
        <div class="triangle"></div>
      </div>
      <el-card class="box-card register-card">
        <el-form ref="form" :model="form" :rules="rules">
          <el-form-item prop="username">
            <el-input v-model="form.username" placeholder="请输入用户名" prefix-icon="fa fa-user" ></el-input>
          </el-form-item>
          <el-form-item prop="deptId">
            <el-select v-model="form.deptId" placeholder="请选择部门" style="width: 100%">
              <el-option v-for="item in deptOptions"
                         :key="item.deptName" :label="item.deptName" :value="item.pkId">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item prop="positionId">
            <el-select v-model="form.positionId" placeholder="请选择岗位" style="width: 100%">
              <el-option v-for="item in positionOptions"
                         :key="item.positionName" :label="item.positionName" :value="item.pkId">
              </el-option>
            </el-select>
          </el-form-item>
          <el-form-item prop="phone">
            <el-input v-model="form.phone" placeholder="请输入手机号" prefix-icon="fa fa-phone"></el-input>
          </el-form-item>
          <el-form-item prop="age">
            <el-input v-model.number="form.age" placeholder="请输入年龄" ></el-input>
          </el-form-item>
          <el-form-item prop="email">
            <el-input v-model="form.email" placeholder="请输入邮箱" ></el-input>
          </el-form-item>
          <el-form-item prop="pwd">
            <el-input v-model="form.pwd" type="password" placeholder="请输入密码" prefix-icon="fa fa-lock"></el-input>
          </el-form-item>
          <el-form-item prop="pwd2">
            <el-input v-model="form.pwd2" type="password" placeholder="请确认密码" prefix-icon="fa fa-lock"></el-input>
          </el-form-item>
          <el-form-item style="text-align: center;">
            <el-button @click="toLogin"  >返回登录</el-button>
            <el-button @click="submitForm('form')" type="primary">提交注册
            </el-button>
          </el-form-item>
        </el-form>
      </el-card>
    </div>
  </div>

</template>
<script>
export default {
  data() {
    let validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.form.pwd2 !== '') {
          this.$refs.form.validateField('checkPass');
        }
        callback();
      }
    };
    let validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.form.pwd) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    let checkAge = (rule, value, callback) => {
      if (!value) {
        return callback(new Error('年龄不能为空'));
      }
      if (!Number.isInteger(value)) {
        callback(new Error('请输入数字值'));
      } else {
        if (value <= 0 || value > 120) {
          callback(new Error('年龄必须在1到120之间'));
        } else {
          callback();
        }
      }
    };
    return {
      form: {
        deptId: '',
        positionId: '',
        uin: '',
        username: '',
        pwd: '',
        pwd2: '',
        age: '',
        email: '',
        phone: '',
        status: 'N',
      },
      deptOptions: [],
      positionOptions: [],
      loading: false,
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 2, message: '最少输入2个字符', trigger: 'blur' }
        ],
        deptId: [
          { required: true, message: '请选择部门', trigger: 'change' }
        ],
        positionId: [
          { required: true, message: '请选择岗位', trigger: 'change' }
        ],
        age: [
          { validator: checkAge, trigger: 'blur' }
        ],
        phone: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { min: 11, message: '请输入11个字符', trigger: 'blur' },
          { max: 11, message: '请输入11个字符', trigger: 'blur' },
        ],
        email:[
          { required: true, message: '请输入邮箱地址', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ],
        pwd: [
          { validator: validatePass, trigger: 'blur' }
        ],
        pwd2: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    }
  },
  mounted() {
    this.initPositionList();
    this.initDeptList();

  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          this.register();
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    initDeptList() {
      this.http.get(this.api.dept.list,res=>{
        this.deptOptions = res.data;
      },(error)=>{
        console.log("查询岗位信息错误-》"+error);
      })
    },
    initPositionList() {
      this.http.get(this.api.position.list,res=>{
        this.positionOptions = res.data;
      },(error)=>{
         console.log("查询岗位信息错误-》"+error);
      })
    },
    toLogin() {
      this.$router.push({path: "/login"});
    },
    register() {
      this.http.post(this.api.user.register,this.form,res=>{
        if(res.code == 200){
          this.$message({message: '恭喜你，注册成功！',type: 'success'});
          return false;
        }
        this.$message({message: '注册失败！', type: 'error'});
      },(error)=>{
        console.log("查询岗位信息错误-》"+error);
      })
    }
  }
}
</script>
<style>
.register-content {
  position: absolute;
  width: 100%;
  height: 100%;
}

.register-card {
  border: 0px solid #EBEEF5 !important;
  box-shadow: 0 0px 0px 0 rgba(0, 0, 0, 0) !important;
}

.register-title {
  background: #83d662;
  margin: 20px 0;
  padding: 10px;
  margin-left: -30px;
  width: 350px;
}

.triangle {
  z-index: -1;
  position: absolute;
  margin-top: -23px;
  margin-left: -2px;
  -webkit-transform: rotate(22deg);
  width: 0;
  height: 0;
  border-width: 0 15px 40px;
  border-style: solid;
  border-color: transparent transparent #66994c;
}
</style>