using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LeetCodeCSharp.Models
{
    public class TreeNode
    {
        private int _value;
        private TreeNode _left;
        private TreeNode _right;

        public TreeNode() { }

        public TreeNode(int val)
        {
            this._value = val;
            this._left = this._right = null;
        }

        public TreeNode Left
        {
            get { return _left; }
            set { _left = value; }
        }

        public TreeNode Right
        {
            get { return _right; }
            set { _right = value; }
        }
        
        public int Value
        {
            get { return _value; }
            set { _value = value; }
        }
    }
}
