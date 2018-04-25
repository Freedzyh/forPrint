<script type="text/html" id="address">
    <div id="addressVm">

    </div>
</script>
<script>
    var vm=new Vue({
        el:"#addressVm",
        data:{voucherList:[]},
        methods:{
            setList:function (value) {
                this.voucherList=value;
            }
        }
    });
</script>