/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package fortune;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-10-15")
public class Car implements org.apache.thrift.TBase<Car, Car._Fields>, java.io.Serializable, Cloneable, Comparable<Car> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("Car");

  private static final org.apache.thrift.protocol.TField MAKE_FIELD_DESC = new org.apache.thrift.protocol.TField("make", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField MODEL_FIELD_DESC = new org.apache.thrift.protocol.TField("model", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField YEAR_FIELD_DESC = new org.apache.thrift.protocol.TField("year", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new CarStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new CarTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String make; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String model; // required
  public int year; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    MAKE((short)1, "make"),
    MODEL((short)2, "model"),
    YEAR((short)3, "year");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // MAKE
          return MAKE;
        case 2: // MODEL
          return MODEL;
        case 3: // YEAR
          return YEAR;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __YEAR_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.MAKE, new org.apache.thrift.meta_data.FieldMetaData("make", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.MODEL, new org.apache.thrift.meta_data.FieldMetaData("model", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.YEAR, new org.apache.thrift.meta_data.FieldMetaData("year", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(Car.class, metaDataMap);
  }

  public Car() {
  }

  public Car(
    java.lang.String make,
    java.lang.String model,
    int year)
  {
    this();
    this.make = make;
    this.model = model;
    this.year = year;
    setYearIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Car(Car other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetMake()) {
      this.make = other.make;
    }
    if (other.isSetModel()) {
      this.model = other.model;
    }
    this.year = other.year;
  }

  public Car deepCopy() {
    return new Car(this);
  }

  @Override
  public void clear() {
    this.make = null;
    this.model = null;
    setYearIsSet(false);
    this.year = 0;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getMake() {
    return this.make;
  }

  public Car setMake(@org.apache.thrift.annotation.Nullable java.lang.String make) {
    this.make = make;
    return this;
  }

  public void unsetMake() {
    this.make = null;
  }

  /** Returns true if field make is set (has been assigned a value) and false otherwise */
  public boolean isSetMake() {
    return this.make != null;
  }

  public void setMakeIsSet(boolean value) {
    if (!value) {
      this.make = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getModel() {
    return this.model;
  }

  public Car setModel(@org.apache.thrift.annotation.Nullable java.lang.String model) {
    this.model = model;
    return this;
  }

  public void unsetModel() {
    this.model = null;
  }

  /** Returns true if field model is set (has been assigned a value) and false otherwise */
  public boolean isSetModel() {
    return this.model != null;
  }

  public void setModelIsSet(boolean value) {
    if (!value) {
      this.model = null;
    }
  }

  public int getYear() {
    return this.year;
  }

  public Car setYear(int year) {
    this.year = year;
    setYearIsSet(true);
    return this;
  }

  public void unsetYear() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  /** Returns true if field year is set (has been assigned a value) and false otherwise */
  public boolean isSetYear() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __YEAR_ISSET_ID);
  }

  public void setYearIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __YEAR_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case MAKE:
      if (value == null) {
        unsetMake();
      } else {
        setMake((java.lang.String)value);
      }
      break;

    case MODEL:
      if (value == null) {
        unsetModel();
      } else {
        setModel((java.lang.String)value);
      }
      break;

    case YEAR:
      if (value == null) {
        unsetYear();
      } else {
        setYear((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case MAKE:
      return getMake();

    case MODEL:
      return getModel();

    case YEAR:
      return getYear();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case MAKE:
      return isSetMake();
    case MODEL:
      return isSetModel();
    case YEAR:
      return isSetYear();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof Car)
      return this.equals((Car)that);
    return false;
  }

  public boolean equals(Car that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_make = true && this.isSetMake();
    boolean that_present_make = true && that.isSetMake();
    if (this_present_make || that_present_make) {
      if (!(this_present_make && that_present_make))
        return false;
      if (!this.make.equals(that.make))
        return false;
    }

    boolean this_present_model = true && this.isSetModel();
    boolean that_present_model = true && that.isSetModel();
    if (this_present_model || that_present_model) {
      if (!(this_present_model && that_present_model))
        return false;
      if (!this.model.equals(that.model))
        return false;
    }

    boolean this_present_year = true;
    boolean that_present_year = true;
    if (this_present_year || that_present_year) {
      if (!(this_present_year && that_present_year))
        return false;
      if (this.year != that.year)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetMake()) ? 131071 : 524287);
    if (isSetMake())
      hashCode = hashCode * 8191 + make.hashCode();

    hashCode = hashCode * 8191 + ((isSetModel()) ? 131071 : 524287);
    if (isSetModel())
      hashCode = hashCode * 8191 + model.hashCode();

    hashCode = hashCode * 8191 + year;

    return hashCode;
  }

  @Override
  public int compareTo(Car other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetMake()).compareTo(other.isSetMake());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMake()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.make, other.make);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetModel()).compareTo(other.isSetModel());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetModel()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.model, other.model);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetYear()).compareTo(other.isSetYear());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetYear()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.year, other.year);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("Car(");
    boolean first = true;

    sb.append("make:");
    if (this.make == null) {
      sb.append("null");
    } else {
      sb.append(this.make);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("model:");
    if (this.model == null) {
      sb.append("null");
    } else {
      sb.append(this.model);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("year:");
    sb.append(this.year);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class CarStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CarStandardScheme getScheme() {
      return new CarStandardScheme();
    }
  }

  private static class CarStandardScheme extends org.apache.thrift.scheme.StandardScheme<Car> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, Car struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // MAKE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.make = iprot.readString();
              struct.setMakeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // MODEL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.model = iprot.readString();
              struct.setModelIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // YEAR
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.year = iprot.readI32();
              struct.setYearIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, Car struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.make != null) {
        oprot.writeFieldBegin(MAKE_FIELD_DESC);
        oprot.writeString(struct.make);
        oprot.writeFieldEnd();
      }
      if (struct.model != null) {
        oprot.writeFieldBegin(MODEL_FIELD_DESC);
        oprot.writeString(struct.model);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldBegin(YEAR_FIELD_DESC);
      oprot.writeI32(struct.year);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class CarTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public CarTupleScheme getScheme() {
      return new CarTupleScheme();
    }
  }

  private static class CarTupleScheme extends org.apache.thrift.scheme.TupleScheme<Car> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, Car struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetMake()) {
        optionals.set(0);
      }
      if (struct.isSetModel()) {
        optionals.set(1);
      }
      if (struct.isSetYear()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetMake()) {
        oprot.writeString(struct.make);
      }
      if (struct.isSetModel()) {
        oprot.writeString(struct.model);
      }
      if (struct.isSetYear()) {
        oprot.writeI32(struct.year);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, Car struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.make = iprot.readString();
        struct.setMakeIsSet(true);
      }
      if (incoming.get(1)) {
        struct.model = iprot.readString();
        struct.setModelIsSet(true);
      }
      if (incoming.get(2)) {
        struct.year = iprot.readI32();
        struct.setYearIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
