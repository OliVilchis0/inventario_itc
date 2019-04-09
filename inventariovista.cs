using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
namespace Inventarioitc
{
    #region Inventariovista
    public class Inventariovista
    {
        #region Member Variables
        protected string _id;
        protected string _categoria;
        protected string _descripcion;
        protected string _marca;
        protected string _modelo;
        protected bool _e_fisico;
        protected string _area;
        protected string _encargado;
        protected string _detalle;
        #endregion
        #region Constructors
        public Inventariovista() { }
        public Inventariovista(string id, string categoria, string descripcion, string marca, string modelo, bool e_fisico, string area, string encargado, string detalle)
        {
            this._id=id;
            this._categoria=categoria;
            this._descripcion=descripcion;
            this._marca=marca;
            this._modelo=modelo;
            this._e_fisico=e_fisico;
            this._area=area;
            this._encargado=encargado;
            this._detalle=detalle;
        }
        #endregion
        #region Public Properties
        public virtual string Id
        {
            get {return _id;}
            set {_id=value;}
        }
        public virtual string Categoria
        {
            get {return _categoria;}
            set {_categoria=value;}
        }
        public virtual string Descripcion
        {
            get {return _descripcion;}
            set {_descripcion=value;}
        }
        public virtual string Marca
        {
            get {return _marca;}
            set {_marca=value;}
        }
        public virtual string Modelo
        {
            get {return _modelo;}
            set {_modelo=value;}
        }
        public virtual bool E_fisico
        {
            get {return _e_fisico;}
            set {_e_fisico=value;}
        }
        public virtual string Area
        {
            get {return _area;}
            set {_area=value;}
        }
        public virtual string Encargado
        {
            get {return _encargado;}
            set {_encargado=value;}
        }
        public virtual string Detalle
        {
            get {return _detalle;}
            set {_detalle=value;}
        }
        #endregion
    }
    #endregion
}