public class Punto2
{
  //Recursion1
  public int factorial(int n) {
    if(n==1) {                      //C1
      return n;
    } else {
      return n*factorial(n-1);
    }
  }

  public int bunnyEars(int bunnies) {
    if(bunnies==0){
      return 0;
    }
    return 2+bunnyEars(bunnies-1);
  }

  public int fibonacci(int n) {
    if(n==0 || n==1){
      return n;
    } else {
      return fibonacci(n-1) + fibonacci(n-2);
    }
  }

  public int bunnyEars2(int bunnies) {
    if(bunnies==0)
      return 0;
      else
      if(bunnies%2!=0)
        return 2+bunnyEars2(bunnies-1);
        else
        return 3+bunnyEars2(bunnies-1);
    }

  public int triangle(int rows) {
    if(rows==0) {
      return rows;
    } else {
        return rows+triangle(rows-1);
      }
  }

  //Recursion2
  public boolean groupSum(int start, int[] nums, int target) {
    if(start>=nums.length){
        return target==0;
    }else{
          return groupSum(start+1,nums,target-nums[start])||groupSum(start+1,nums,target);
    }
  }

  public boolean groupNoAdj(int start, int[] nums, int target) {
    if(start>=nums.length){
        return target==0;
    }else{
          return groupNoAdj(start+2,nums,target-nums[start])||groupNoAdj(start+1,nums,target);
    }
  }
/**
* Ejercicio 2.3 - El ejercicio GroupSum5 lo que hace es recibir primero que todo
* tres parametros: un indice, que es un entero el cual siempre es 0; un arreglo
* de numeros de varios numeros enteros y un terger, que es el numero deseado que
* vana a formar los numeros en el arreglo de nums. Este ejercicio comienza
* verificando que el indice sea menor que el numero de elementos en el arreglo,
* el programa va sumar los numeros de todas las maneras posibles hasta poder lle
* gar al numero target puesto, sin embargo, cuando haya un numero divisible por
* el 5, sera contado obligatoriamente y si le prosigue un 1, este no sera contado
* de tal forma que los grupos de suma creados van a tener obligatoriamente los
* multilplos del cinco y no los 1 que le siguen, creando un arbol de muchos varios
* grupos para formar el numero deseado.
*/
  public boolean groupSum5(int start, int[] nums, int target) {
    if(start>=nums.length){
        return target==0;
    }else{
      if(nums[start]%5==0){
        if(start<nums.length-1&&nums[start+1]==1){
          return groupSum5(start+2,nums,target-nums[start]);
        }else{
          return groupSum5(start+1,nums,target-nums[start]);
      }
    }else{
       return groupSum5(start+1,nums,target-nums[start])||groupSum5(start+1,nums,target);
    }
    }
  }

  public boolean groupSumClump(int start, int[] nums, int target) {
    if (start >= nums.length) return target == 0;

      int sum = nums[start];
      int count = 1;
      for (int i = start + 1; i < nums.length; i++)
        if (nums[i] == nums[start]) {
            sum += nums[i];
            count++;
        }
        return groupSumClump(start + count, nums, target - sum)
                || groupSumClump(start + count, nums, target);
    }

  public boolean splitArray(int[] nums) {
    return helper(0,nums,0,0);
  }

  public boolean helper(int start,int[] nums,int sum1,int sum2){
    if(start>=nums.length) return sum1==sum2;
    return helper(start+1,nums,sum1+nums[start],sum2) || helper(start+1,nums,sum1,sum2+nums[start]);
  }

  public boolean split53(int[] nums) {
    return helper(0,nums,0,0);
  }

  public boolean helper(int start,int[] nums,int sum1,int sum2){
    if(start>=nums.length) return sum1==sum2;
    else {
      if(nums[start]%5==0)
        return helper(start+1,nums,sum1+nums[start],sum2);
        else if(nums[start]%3==0) {
          return helper(start+1,nums,sum1,sum2+nums[start]);
        } else {
          return helper(start+1,nums,sum1+nums[start],sum2) || helper(start+1,nums,sum1,sum2+nums[start]);
        }
      }
    }
}
