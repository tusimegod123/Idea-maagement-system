<template>
  <div>
    <!-- <CTableWrapper   :items="items" :fields="fields"> -->
    <CCardBody>
      <CDataTable
        :items="items"
        :fields="fields"
        :items-per-page="small ? 10 : 7"
        pagination
      >
        <template #header>
          <CIcon name="cil-grid" /> Ideas Table
          <div class="card-header-actions">
            <a
              href="https://coreui.io/vue/docs/components/nav"
              class="card-header-action"
              rel="noreferrer noopener"
              target="_blank"
            >
              <small class="text-muted">docs</small>
            </a>
          </div>
        </template>
        <template #Update="{ item }">
          <td class="py-2">
            <CButton
              color="primary"
              variant="outline"
              square
              size="sm"
              @click="openModel(item) (darkModal=true) "

            >
              Update
            </CButton>
          </td>
        </template>
        <!-- <template #Delete>
          <td class="py-2">
              <CButton color="dark" @click="darkModal = true" class="mr-1">
                Launch dark modal
              </CButton>
          
          </td>
        </template> -->
      </CDataTable>
    </CCardBody>

    <CModal
      :show.sync="darkModal"
      :no-close-on-backdrop="true"
      :centered="true"
      title="Modal title 2"
      size="lg"
      color="dark"
    >
      <CCard>
        <CCardHeader>
          <strong>You are about to edit your Idea</strong>
        </CCardHeader>

        <form >
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
                <CInput class="mr-2" placeholder="Idea Title" name="ideaTitle">
                  <template #label>
                    <small>Idea Title:&nbsp;</small>
                  </template>
                </CInput>
              </CCol>
              <CCol sm="5">
                <CInput :placeholder="ideaUpdate.ideaDescription" v-model="ideaDescription">
                  <template #label>
                    <small>Idea Description:&nbsp;</small>
                  </template> </CInput
                ><br />
              </CCol>
            </CRow>
            <CRow>
              <CCol sm="5">
                <CInput class="mr-2" type="date" name="dateOfSubmission">
                  <template #label>
                    <small>Date of Submition:&nbsp;</small>
                  </template>
                </CInput>
              </CCol>
              <CCol sm="5">
                <CInput placeholder="--Select--" name="category">
                  <template #label>
                    <small>Category:&nbsp;</small>
                  </template> </CInput
                ><br />
              </CCol>
            </CRow>
            <CRow>
              <CButton
                type="submit"
                size="sm"
                color="primary"
                style="margin-left: 40px"
                ><CIcon name="cil-check-circle" /> Submit</CButton
              >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <CButton
                type="reset"
                size="sm"
                color="danger"
                style="margin-left: 10px"
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
      <template #header>
        <h3>Hello Godwin</h3>
        <CButtonClose @click="darkModal = false" class="text-white" />
      </template>
      <template #footer>
        <CButton @click="darkModal = false" color="danger">Discard</CButton>
        <CButton @click="darkModal = false" color="success">Accept</CButton>
      </template>
    </CModal>
    <!-- </CTableWrapper> -->
  </div>
</template>

<script>
import CTableWrapper from "./Table.vue";
//import ApplicationDatService from '../../services/ApplicationDataService';
import Vue from "vue";

//import axios from "axios";
import axios from "axios";
import VueAxios from "vue-axios";
import { cilLink } from "@coreui/icons";
Vue.use(VueAxios, axios);

// const ideas = () =>{
//    Vue.axios.get("http://localhost:4000/api/ideas")
//     .then((response) => {
//      this.ideas = response.data;
//       console.warn(response.data);
//     });
// }

// const fields = [
//   'ideaTitle',
//   { key: 'description', label: 'Description' },

//   // 'role',
//   // 'status'
// ]

const items = [];

export default {
  name: "IdeaView",
  components: { CTableWrapper },
  data() {
    return {
      darkModal: false,
      items,
      ideaTitle:"",
      ideaDescription:"",
      ideaUpdate:"",
      //  ideas: {
      //   ideaTitle:this.ideaTitle,
      //   ideaDescription:this.ideaDescription
      // },
      fields: [
        "ideaTitle",
        "ideaDescription",
        "createdBy",
        "lastModifiedBy",
        "createdDate",
        "notes",
        { key: "Update" },
        { key: "Delete" },
      ],
    };
  },
  methods: {
    fetchIdeas(allIdeas) {
      this.items = allIdeas.map((item) => {
        return {
          ideaTitle: item.ideaTitle,
          ideaId: item.ideaId,
          currentIdeaId: item.ideaId,
          description: item.ideaDescription,
          createdBy: item.createdBy,
          lastModifiedBy: item.lastModifiedBy,
          createdDate: item.createdDate,
          note: item.notes.map((note) => note.comment),
        };
      });
    },
    openModel(item) {
      this.darkModal = true;
      this.currentIdeaId = item.ideaId;
       alert(item.ideaId)
          this.ideaUpdate={
            ideaTitle: item.ideaTitle,
          ideaDescription: item.ideaDescription,
     
         } ;
           this.ideaUpdate = item;
      // this.ideas = updateAnIdea.map((idea) => {
      //   return {};
      // });
    },
  },
  updateIdea(ideaUpdate) {
    Vue.axios
      .patch(`http://localhost:4000/api/idea/${ideaUpdate.ideaId}`,ideaUpdate, {
        headers: {
          Authorization:
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb3JpcyIsImV4cCI6MTYyMjI0MTkwNywiaWF0IjoxNjIyMjA1OTA3fQ.c3pifHTPtF5fl7gIz1cYVoRpimmw3SNEPGsi603r5Uo",
        },
      })
      .then((response) => {
        this.updateIdea(response.data);
        console.warn(this.ideas);
      });
  },

  mounted() {
    Vue.axios
      .get("http://localhost:4000/api/idea", {
        headers: {
          Authorization:
            "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb3JpcyIsImV4cCI6MTYyMjI0MTkwNywiaWF0IjoxNjIyMjA1OTA3fQ.c3pifHTPtF5fl7gIz1cYVoRpimmw3SNEPGsi603r5Uo",
        },
      })
      .then((response) => {
        this.fetchIdeas(response.data);
        console.warn(this.items);
      });
  },
  // computed: {
  //   computedItems () {
  //     return ideas.map(idea => {
  //       return {
  //         ...idea,
  //         registeredTimestamp: idea.registered.timestamp,
  //         registeredDate: idea.registered.date
  //       }
  //     })
  //   },
  //   dateFilteredItems() {
  //     return this.computedItems.filter(idea => {
  //       const date = idea.registeredTimestamp
  //       return date >= this.startDate && date <= this.endDate
  //     })
  //   }
  // },
  // methods: {
  //   setDateFilter (e, end) {
  //     if (end) {
  //       this.endDate = new Date(e.target.value).getTime()
  //     } else {
  //       this.startDate = new Date(e.target.value).getTime()
  //     }
  //   }
  // }
};
//   methods:{refreshIdeas(){
//     ApplicationDatService.getAllIdeas(this.msg)
//     .then(response =>{
//       this.ideas = response.data;
//       console.log(response.data);
//     })
//     }
//   },
//   created(){
//     this.refreshIdeas();
//   }

// };
</script>

//  mounted() {
//     fetch("/api/ideas")
//       .then((response) => response.text())
//       .then((data) => {
//         this.msg = data;
//       });
//   },