using System;
using System.Collections.Generic;
using System.Text;

namespace HW6
{
    internal interface IStore
    {
        void Sell(Item item, string name);
        void AddProduct();
        void ResetStore();
    }
}
