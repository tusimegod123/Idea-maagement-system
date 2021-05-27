<template>
  <div>
    <CCard>
      <CCardHeader> <strong>Submit An Idea</strong> </CCardHeader>

      <form @submit="postData" method="post">
        <CCardBody>
          <!-- Bootstrap Vue has some problems with Inline forms that's why we use some standard bootstrap classes -->

          <!-- <CForm > -->
            <!-- <CRow>
              <CCol sm="5">
                <CInput class="mr-2" placeholder="Jane Doe">
                  <template #label>
                    <small>Name:&nbsp;</small>
                  </template>
                </CInput>
              </CCol>
              <CCol sm="5">
                <CInput placeholder="jane.doe@example.com" autocomplete="email">
                  <template #label>
                    <small>Email:&nbsp;</small>
                  </template> </CInput
                ><br />
              </CCol>
            </CRow> -->
                <CRow>
              <CCol sm="5">
                <CInput class="mr-2" placeholder="Idea Title" name="ideaTitle" v-model="posts.ideaTitle">
                  <template #label>
                    <small>Idea Title:&nbsp;</small>
                  </template>
                </CInput>
              </CCol>
              <CCol sm="5">
                <CInput placeholder="idea Description"  name="ideaDescription" v-model="posts.ideaDescription">
                  <template #label>
                    <small>Idea Description:&nbsp;</small>
                  </template> </CInput
                ><br />
              </CCol>
            </CRow>
                <CRow>
              <CCol sm="5">
                <CInput class="mr-2" type="date" name="dateOfSubmission" v-model="posts.dateOfSubmission">
                  <template #label>
                    <small>Date of Submition:&nbsp;</small>
                  </template>
                </CInput>
              </CCol>
              <CCol sm="5">
                <CInput placeholder="--Select--" name="category" v-model="posts.category">
                  <template #label>
                    <small>Category:&nbsp;</small>
                  </template> </CInput
                ><br />
              </CCol>
            </CRow>
            <CRow>
                 <CButton type="submit" size="sm" color="primary" style="margin-left:40px;"
            ><CIcon name="cil-check-circle" /> Submit</CButton
          >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
          <CButton type="reset" size="sm" color="danger" style="margin-left:10px;"
            ><CIcon name="cil-ban" /> Reset</CButton
          >
            </CRow>
           
          <!-- </CForm> -->
        </CCardBody>
        <!-- <CCardFooter>
          <CButton type="submit" size="sm" color="primary"
            ><CIcon name="cil-check-circle" /> Submit</CButton
          >
          <CButton type="reset" size="sm" color="danger"
            ><CIcon name="cil-ban" /> Reset</CButton
          >
        </CCardFooter> -->
      </form>
    </CCard>
  </div>
</template>

<script>
import Vue from "vue";

//import axios from "axios";
import axios from "axios";
import VueAxios from "vue-axios";
Vue.use(VueAxios, axios);
export default {
  name: "Idea",

  data() {
    return {
      posts:{
        ideaTitle:null,
        ideaDescription:null,
        dateOfSubmission:null,
        category:null
      }
    };
  },
  methods: {
    postData(e) {
      this.axios.post("http://localhost:4000/api/ideas",this.posts)
      .then((response)=>{
        console.warn(response);
      })
  //    console.warn(this.posts);
      e.preventDefault();
      

    },
  },
};
</script>