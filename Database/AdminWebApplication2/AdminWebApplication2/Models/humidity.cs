//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace AdminWebApplication2.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class humidity
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public humidity()
        {
            this.measurements = new HashSet<measurement>();
        }
    
        public int id { get; set; }
        public string b_id { get; set; }
        public Nullable<double> highe_acceptable_value { get; set; }
        public Nullable<double> low_acceptable_value { get; set; }
        public Nullable<System.DateTime> timestamp { get; set; }
        public string value { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<measurement> measurements { get; set; }
    }
}
