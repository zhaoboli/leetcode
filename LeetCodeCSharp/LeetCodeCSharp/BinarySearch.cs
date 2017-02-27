using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeCSharp
{
    public class BinarySearch
    {
        public static int SearchOne(int[] arr, int target)
        {
            if (arr == null || arr.Length == 0)
                return -1;

            int start = 0;
            int end = arr.Length - 1;

            //jump out of loop when adjacent
            while (start + 1 < end)
            {
                int mid = start + (end - start) / 2;
                if (arr[mid] == target)
                {
                    return mid;
                }

                if (arr[mid] < target)
                {
                    start = mid;
                }
                else {
                    end = mid;
                } 
            }

            if (arr[start] == target)
            {
                return start;
            }

            if (arr[end] == target)
            {
                return end;
            }

            return -1;
        }

        public static int SearchLastPosition(int[] source, int target)
        {
            if (source == null | source.Length == 0)
                return -1;

            int start = 0;
            int end = source.Length - 1;

            while (start + 1 < end)
            {
                int mid = start + (end - start) / 2;
                if (source[mid] == target)
                {
                    start = mid;
                }

                if (source[mid] < target)
                {
                    start = mid;
                }
                else if( source[mid] > target)
                {
                    end = mid;
                }
            }

            if(source[end] == target)
            {
                return end;
            }
            if(source[start] == target)
            {
                return start;
            }

            return -1;
        }
    }
}
