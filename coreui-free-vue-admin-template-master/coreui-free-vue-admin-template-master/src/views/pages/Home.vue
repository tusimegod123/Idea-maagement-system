<template>
  <div>
    <p>welcome</p>
    <h2>{{ msg }}</h2>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  data() {
    return {
      msg: "",
    };
  },
  mounted() {
    fetch("/api/messages/hello")
      .then((response) => response.text())
      .then((data) => {
        this.msg = data;
      });
  },
};
</script>