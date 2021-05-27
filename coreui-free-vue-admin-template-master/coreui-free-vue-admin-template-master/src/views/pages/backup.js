{/* <template>
  <div>
    <p>welcome</p>
    <!-- <h2>{{ msg }}</h2> -->
    <!-- <ul>
      <li v-for="idea in ideas" v-bind:key="idea.ideaId">{{ ideas }}</li>
    </ul> -->
    <table>
      <th>
        <td>Title</td>
        <td>Description</td>
      </th>
       <tr  v-for="idea in items" v-bind:key="idea.id">
        <td>{{idea.ideaTitle}}</td>
        <td>Description</td>
      </tr>
    </table>

     <!-- <CRow>
    <CCol col="12" xl="8">
      <CCard>
        <CCardHeader>
         Ideas
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
  </CRow> -->
  </div>
</template>

<script>
//import ApplicationDatService from '../../services/ApplicationDataService';
import Vue from "vue";
import ideas from "../../assets/services/ApplicationDataService"
//import axios from "axios";
import axios from "axios";
import VueAxios from "vue-axios";
Vue.use(VueAxios, axios);

export default {
  name: "HomeView",
  // mounted() {
  //   return { 
  //     items: ideas,
  //      fields: [
  //       { key: 'ideaTitle', label: 'Idea Title', _classes: 'font-weight-bold' },
  //       { key: 'description' },
  //       { key: 'role' },
  //       { key: 'status' }
  //     ],
  //     }
  // },
  data() {
     return { 
      items: ideas,
       fields: [
        { key: 'ideaTitle', label: 'Idea Title', _classes: 'font-weight-bold' },
        { key: 'description' },
        { key: 'role' },
        { key: 'status' }
      ],
      activePage: 1
      }
    // Vue.axios.get("http://localhost:4000/api/ideas")
    // .then((response) => {
    //  this.lists = response.data;
    //   console.warn(response.data);
    // });
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
  methods: {
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
  }
}
</script>
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

// import usersData from './UsersData'
// export default {
//   name: 'Users',
//   data () {
//     return {
//       items: usersData,
//       fields: [
//         { key: 'username', label: 'Name', _classes: 'font-weight-bold' },
//         { key: 'registered' },
//         { key: 'role' },
//         { key: 'status' }
//       ],
//       activePage: 1
//     }
//   },
//   watch: {
//     $route: {
//       immediate: true,
//       handler (route) {
//         if (route.query && route.query.page) {
//           this.activePage = Number(route.query.page)
//         }
//       }
//     }
//   },
//   methods: {
//     getBadge (status) {
//       switch (status) {
//         case 'Active': return 'success'
//         case 'Inactive': return 'secondary'
//         case 'Pending': return 'warning'
//         case 'Banned': return 'danger'
//         default: 'primary'
//       }
//     },
//     rowClicked (item, index) {
//       this.$router.push({path: `users/${index + 1}`})
//     },
//     pageChange (val) {
//       this.$router.push({ query: { page: val }})
//     }
//   }
// }
 */}
