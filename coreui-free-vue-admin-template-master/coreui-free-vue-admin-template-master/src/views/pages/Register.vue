<template>
  <div class="d-flex align-items-center min-vh-100">
    <CContainer fluid>
      <CRow class="justify-content-center">
        <CCol md="6">
          <CCard class="mx-4 mb-0">
            <CCardBody class="p-4">
              <form @submit="postData" method="post">
                <!-- <CForm> -->
                <h1>Register</h1>
                <p class="text-muted">Create your account</p>
                <CInput
                  placeholder="First Name"
                  name="firstName"
                  type="text"
                  v-model="users.firstName"
                  class="mb-4"
                >
                  <template #prepend-content
                    ><CIcon name="cil-lock-locked"
                  /></template>
                </CInput>
                <CInput
                  placeholder="Last Name"
                  name="lastName"
                  type="text"
                  v-model="users.lastName"
                  class="mb-4"
                >
                  <template #prepend-content
                    ><CIcon name="cil-lock-locked"
                  /></template>
                </CInput>
                <!-- <CSelect
                  label="Country"
                  name="contry_id"
                  horizontal
                  :value.sync="selected"
                 :options:v-for="item in items>{{item}}"
                  placeholder="Please select"
                  
                /> -->
                <label>Country:</label>
                <select id="select-option" name="country" v-model="users.country" >
                
                 <option id="select-option"  name="country" v-bind:key="item.id" :value="item.countryId" v-for="item in items">{{ item.countryName }}</option>
                </select><br><br>
                <!-- <c-select
                  label="time"
                  :options="options"
                  :value.sync="selectedValue"
                  placeholder="placeholder"
                /> -->
               
                <CInput
                  placeholder="Username"
                  name="username"
                  v-model="users.username"
                >
                  <template #prepend-content
                    ><CIcon name="cil-user"
                  /></template>
                </CInput>
                <CInput placeholder="Email" autocomplete="email" prepend="@" />
                <CInput
                  placeholder="Password"
                  name="password"
                  type="password"
                  v-model="users.password"
                  autocomplete="new-password"
                >
                  <template #prepend-content
                    ><CIcon name="cil-lock-locked"
                  /></template>
                </CInput>
                <CSelect
                  label="Roles"
                  name="roles"
                  horizontal
                  :options="options"
                  placeholder="Please select"
                />

                <CButton color="success" type="submit" block
                  >Create Account</CButton
                >
                <!-- </CForm> -->
              </form>
            </CCardBody>
            <CCardFooter class="p-4">
              <CRow>
                <CCol col="6">
                  <CButton block color="facebook"> Facebook </CButton>
                </CCol>
                <CCol col="6">
                  <CButton block color="twitter"> Twitter </CButton>
                </CCol>
              </CRow>
            </CCardFooter>
          </CCard>
        </CCol>
      </CRow>
    </CContainer>
  </div>
</template>

<script>
import Vue from "vue";
import vSelect from 'vue-select';

Vue.component('v-select', vSelect)

//import axios from "axios";
import axios from "axios";
import VueAxios from "vue-axios";
Vue.use(VueAxios, axios);

const items = [];
export default {
  name: "Register",

  data() {
    return {
      selected: '',
      items,
      users: {
        firstName: null,
        lastname: null,
        username: null,
        password: null,
        roles: null,
        country:null
      },
      
   
      // options: [
      //   { value: "1", label: "label1" },
      //   { value: "2", label: "label2" },
      //   { value: "3", label: "label3" }
      // ],
      // selectedValue: items
    };
    },
  computed: {
    options() {
      return Object.keys(items);
    },
    //property computing current state to the same structure as received.
    selectObject() {
      return this.options.reduce((obj, option) => {
        obj[option] = option === this.selected;
        return obj;
      }, {});
    },
  },

  methods: {
    postData(e) {
      this.axios
        .post("http://localhost:4000/api/users", this.users)
        .then((response) => {
          console.warn(response);
        });
      //    console.warn(this.posts);
      e.preventDefault();
    },
    fetchCountries(allICountries) {
      this.items = allICountries.map((item) => {
        return {
          countryId: item.countryId,
          countryName: item.countryName,
        };
      });
    },
  },
  mounted() {
    Vue.axios.get("http://localhost:4000/api/country").then((response) => {
      this.fetchCountries(response.data);
      console.warn(this.items);
    });
  },
};
</script>
<style scoped>
#select-option{
  width: 100%;
  border: 1px solid#dbd9d9;
  height: 35px;
  border-radius: 4px;
}
</style>
