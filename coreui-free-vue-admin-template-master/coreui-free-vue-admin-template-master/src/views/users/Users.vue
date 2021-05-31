<template>
  <CRow>
    <CCol col="12" xl="8">
      <CCard>
        <CCardHeader>
          Users
        </CCardHeader>
        <CCardBody>
          <CDataTable
            hover
            striped
            :items="items"
            :fields="fields"
            :items-per-page="5"
            clickable-rows
            :active-page="activePage"
            @row-clicked="rowClicked"
            :pagination="{ doubleArrows: false, align: 'center'}"
            @page-change="pageChange"
          >
            <template #status="data">
              <td>
                <CBadge :color="getBadge(data.item.status)">
                  {{data.item.status}}
                </CBadge>
              </td>
            </template>
          </CDataTable>
        </CCardBody>
      </CCard>
    </CCol>
  </CRow>
</template>

<script>
import usersData from './UsersData'
import Vue from "vue";

//import axios from "axios";
import axios from "axios";
import VueAxios from "vue-axios";
Vue.use(VueAxios, axios);
export default {
  name: 'Users',
  data () {
    return {
      items: [],
      fields: ['user_id', 'firstName', 'lastName','username', 'role'],
      activePage: 1
    }
  },
  watch: {
    $route: {
      immediate: true,
      handler (route) {
        if (route.query && route.query.page) {
          this.activePage = Number(route.query.page)
        }
      }
    }
  },

// methods:{
//    fetchIdeas(allIdeas){
//      this.items = allIdeas.map(item =>{
//        return {
//          ideaTitle: item.ideaTitle,
//          description: item.ideaDescription,
//          createdBy: item.createdBy,
//          lastModifiedBy: item.lastModifiedBy,
//          createdDate: item.createdDate,
//          note: item.notes.map(note => note.comment)


//        }
//      })
//    }
//   },
//   mounted() {
//     Vue.axios.get("http://localhost:4000/api/ideas")
//     .then((response) => {
//      this.fetchIdeas(response.data) 
//       console.warn(this.items);
//     });
//   },


  methods: {
    fetchUsers(allIusers){
     this.items = allIusers.map(item =>{
       return {
         user_id: item.id,
         firstName: item.firstName,
         lastName: item.lastName,
         username: item.username,
         role: item.roles.map(role => role.name)
       }
     })
   },
    getBadge (status) {
      switch (status) {
        case 'Active': return 'success'
        case 'Inactive': return 'secondary'
        case 'Pending': return 'warning'
        case 'Banned': return 'danger'
        default: 'primary'
      }
    },
    rowClicked (item, index) {
      this.$router.push({path: `users/${index + 1}`})
    },
    pageChange (val) {
      this.$router.push({ query: { page: val }})
    }
  },
   mounted() {
    Vue.axios.get("http://localhost:4000/api/users",{
      headers: {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb3JpcyIsImV4cCI6MTYyMjIzMTI1NSwiaWF0IjoxNjIyMTk1MjU1fQ.ud8Oy3YYZyPhjM44yqBMEnlQAEROHEhHhebq1C9yTPo"
      }
    })
    .then((response) => {
     this.fetchUsers(response.data) 
      console.warn(this.items);
    });
  },
}
</script>
