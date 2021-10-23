<template>
  <div>
    <el-row>
      <el-col :span="24">
        <el-col :span="20">
          <el-row :gutter="20">
            <el-col :span="24" style="padding: 15px; ">
              <el-row :gutter="20" style="background: #f4f4f5;padding:10px;">
                <el-col :span="5">
                  <el-input placeholder="部门名称" v-model="searArgs.checkName" size="small" clearable></el-input>
                </el-col>
                <el-col :span="2" style="text-align: center;">
                  <el-button type="success" icon="el-icon-search" size="small" circle></el-button>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </el-col>
        <el-col :span="1">&nbsp;</el-col>
      </el-col>
    </el-row>
    <el-row>
      <el-button @click="addDept" type="primary">新增</el-button>
    </el-row>
    <el-table :data="tableData" ref="table" style="width: 100%">
      <el-table-column class="text-overflow"
                       :show-overflow-tooltip="true" prop="deptName" label="部门名称">
      </el-table-column>
      <el-table-column class="text-overflow"
                       :show-overflow-tooltip="true" prop="deptCode" label="部门编号">
      </el-table-column>
      <el-table-column class="text-overflow"
                       :show-overflow-tooltip="true" prop="remark" label="部门描述">
      </el-table-column>
      <el-table-column width="100" label="操作" fixed="right">
        <template slot-scope="scope">
          <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)"></el-button>
          <el-button type="text" icon="el-icon-delete" @click="handleDelete(scope.$index, scope.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination background layout="prev, pager, next" ></el-pagination>

    <!--    编辑框-->
    <dept-edit :dialogVisible="dialogVisible" v-if="dialogVisible" :params="params"
               @dept-edit-close="deptEditClose"></dept-edit>
  </div>

</template>
<script>
export default {
  data() {
    return {
      searArgs: {
        deptName: ''
      },
      params: {
        pkId: "",
        operation: ""
      },
      tableData: [],
      dialogVisible: false,//显示编辑框
    }
  },
  mounted() {
    this.getData()
  },
  methods: {
    deptEditClose() {
      this.dialogVisible = false;
      this.getData();
    },
    handleEdit(index, row) {
      this.params.pkId = row.pkId;
      this.params.operation = "修改";
      this.dialogVisible = true;
    },
    addDept() {
      this.params.pkId = "";
      this.params.operation = "新增";
      this.dialogVisible = true;
    },
    handleDelete(index, row) {
      this.$confirm('确认删除部门吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.http.get(this.api.dept.deleteById + "/" + row.pkId, res => {
          if (res.code == 200) {
            this.$message({type: 'success', message: '删除成功!'});
            this.getData();
          }
        }, (error) => {
          console.log(error)
        })
      }).catch(() => {
        this.$message({ type: 'info', message: '已取消删除'});
      });
    },
    getData() {
      this.http.get(this.api.dept.list, res => {
        this.tableData = res.data;
      }, (error) => {
        console.log(error)
      })
    },
  },
  components: {
    "dept-edit": deptEdit
  }
}
import deptEdit from "./deptEdit.vue";
</script>
<style>
.grid-content {
  padding: 15px;
  height: 65px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

.grid-content img {
  height: 65px;
}

.grid-content p {
  font-size: 16px;
  margin: 0;
  padding: 0;
  color: #00b8d2;
  font-weight: 600;
}

.check-info {
  float: right;
  text-align: right;
  color: #00b8d2;
}

.check-info span:nth-child(1) {
  font-size: 35px;
  font-weight: 700;
  display: block;
}

.el-table td, .el-table th {
  padding: 5px 0 !important;
}

.el-table .cell {
  cursor: pointer !important;
}
</style>