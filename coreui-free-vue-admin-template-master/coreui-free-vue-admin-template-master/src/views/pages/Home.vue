<template>
  <div>
    <p>welcome</p>
    <!-- <h2>{{ msg }}</h2> -->
    <!-- <ul>
      <li v-for="idea in ideas" v-bind:key="idea.ideaId">{{ ideas }}</li>
    </ul> -->
    <!-- <table>
      <th>
        <td>Title</td>
        <td>Description</td>
      </th>
       <tr  v-for="idea in ideas" v-bind:key="idea.id">
        <td>{{idea.ideaTitle}}</td>
        <td>Description</td>
      </tr>
    </table> -->

   <CTableWrapper :items="items">
          <template #header>
            <CIcon name="cil-grid"/> Ideas Table
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
        </CTableWrapper>
  </div>
</template>

<script>
import CTableWrapper from '../../views/base/Table.vue';
//import ApplicationDatService from '../../services/ApplicationDataService';
import Vue from "vue";

//import axios from "axios";
import axios from "axios";
import VueAxios from "vue-axios";
Vue.use(VueAxios, axios);

// const ideas = () =>{
//    Vue.axios.get("http://localhost:4000/api/ideas")
//     .then((response) => {
//      this.ideas = response.data;
//       console.warn(response.data);
//     });
// }

const fields = [
  'ideaTitle',
  { key: 'description', label: 'Description' }
  // 'role',
  // 'status'
]

const items = [];

export default {
  name: "HomeView",
  components:{CTableWrapper},
  data() {
    return { 
      items,
      fields
      }
  },
  mounted() {
    Vue.axios.get("http://localhost:4000/api/ideas")
    .then((response) => {
     this.items = response.data;
      console.warn(response.data);
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