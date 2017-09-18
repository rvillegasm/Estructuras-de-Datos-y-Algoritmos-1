// Array 2
public int countEvens(int[] nums) {
  int count=0;
  for(int i=0; i<nums.length; i++) {
    if(nums[i]%2==0) {
      count++;
    }
  }
  return count;
}

public int bigDiff(int[] nums) {
  int maximo=0;
  int minimo=100;
  for(int i=0; i<nums.length; i++) {
     int maxl = Math.max(nums[i], maximo);
     if(maxl > maximo) {
       maximo = maxl;
     }
  }
  for(int i=0; i<nums.length; i++) {
     int minl = Math.min(nums[i], minimo);
     if(minl < minimo) {
       minimo = minl;
     }
  }
  return maximo - minimo;
}

public int sum13(int[] nums) {
    int res=0;
    for(int i=0; i<nums.length; i++) {
      if(nums[i]!=13) {
        res = res + nums[i];
      } else if(i<=nums.length-1) {
        i++;
      }
    }
    return res;
}

public boolean has22(int[] nums) {
  for(int i=0; i<=nums.length-2; i++) {
    if(nums[i]==2 && nums[i+1]==2) {
      return true;
    }
  }
  return false;
}

public boolean lucky13(int[] nums) {
  for(int i=0; i<nums.length; i++) {
    if(nums[i]==1 || nums[i]==3) {
      return false;
    }
  }
  return true;
}

// Array 3
public int maxSpan(int[] nums) {
    if(nums.length>0){
      int span=1;
      int count = 0;
      for(int i=0;i<nums.length;i++){
        for(int j=nums.length-1;j>=i;j--){
          if(nums[i]==nums[j]){
            count= (j-i)+1;
            if(count>span){
              span=count;
              break;
            }
          }
        }
      }
      return span;
    }
  return 0;
}

public int[] fix34(int[] nums) {
  for(int i=0;i<nums.length;i++){
    if(nums[i]==4){
      for(int j=0;j<nums.length;j++){
        if(nums[j]==3&&j+1<nums.length){
          int temp=nums[i];
          nums[i]=nums[j+1];
          nums[j+1]=temp;
        }
      }
    }
  }
  return nums;
}

public int[] fix45(int[] nums) {
  for(int i=0;i<nums.length;i++){
    if(nums[i]==5){
      for(int j=0;j<nums.length;j++){
        if(nums[j]==4&&j+1<nums.length){
          int temp=nums[i];
          nums[i]=nums[j+1];
          nums[j+1]=temp;
        }
      }
    }
  }
  return nums;
}

public boolean canBalance(int[] nums) {
  int contizq=0;
  int contder=0;
  for(int i=0;i<nums.length;i++){
    contizq=contizq+nums[i];
    for(int j=i+1;j<nums.length;j++){
      contder=contder+nums[j];
    }
    if(contizq==contder){
      return true;
    }
    countder = 0;
  }
  return false;
}

public boolean linearIn(int[] outer, int[] inner) {
  int count=0;
  for(int i=0;i<outer.length;i++){
    for(int j=count;j<inner.length;j++){
      if(inner[j]==outer[i]){
        count++;
        break;
      }
    }
  }
  if(count>=inner.length){
    return true;
  }else{
    return false;
  }
} 
