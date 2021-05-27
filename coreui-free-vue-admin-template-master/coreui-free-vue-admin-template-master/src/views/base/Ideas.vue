<template>
  <div>
   

   <CTableWrapper :items="items" :fields="fields" >
    
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
import CTableWrapper from './Table.vue';
//import ApplicationDatService from '../../services/ApplicationDataService';
import Vue from "vue";

//import axios from "axios";
import axios from "axios";
import VueAxios from "vue-axios";
import { cilLink } from '@coreui/icons';
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
  name: "IdeaView",
  components:{CTableWrapper},
  data() {
    return { 
      items,
      fields:['ideaTitle','ideaDescription','createdBy', 'lastModifiedBy','createdDate','notes']
      }
  },
  methods:{
   fetchIdeas(allIdeas){
     this.items = allIdeas.map(item =>{
       return {
         ideaTitle: item.ideaTitle,
         description: item.ideaDescription,
         createdBy: item.createdBy,
         lastModifiedBy: item.lastModifiedBy,
         createdDate: item.createdDate,
         note: item.notes.map(note => note.comment)


       }
     })
   }
  },
  mounted() {
    Vue.axios.get("http://localhost:4000/api/ideas")
    .then((response) => {
     this.fetchIdeas(response.data) 
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