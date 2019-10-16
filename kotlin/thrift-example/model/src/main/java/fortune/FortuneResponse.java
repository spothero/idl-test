/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package fortune;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-10-15")
public class FortuneResponse implements org.apache.thrift.TBase<FortuneResponse, FortuneResponse._Fields>, java.io.Serializable, Cloneable, Comparable<FortuneResponse> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("FortuneResponse");

  private static final org.apache.thrift.protocol.TField FORTUNE_FIELD_DESC = new org.apache.thrift.protocol.TField("fortune", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField LUCKY_NUMBERS_FIELD_DESC = new org.apache.thrift.protocol.TField("lucky_numbers", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField LUCKY_ANIMAL_FIELD_DESC = new org.apache.thrift.protocol.TField("lucky_animal", org.apache.thrift.protocol.TType.I32, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new FortuneResponseStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new FortuneResponseTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String fortune; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> lucky_numbers; // required
  public @org.apache.thrift.annotation.Nullable Animal lucky_animal; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    FORTUNE((short)1, "fortune"),
    LUCKY_NUMBERS((short)2, "lucky_numbers"),
    LUCKY_ANIMAL((short)3, "lucky_animal");

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
        case 1: // FORTUNE
          return FORTUNE;
        case 2: // LUCKY_NUMBERS
          return LUCKY_NUMBERS;
        case 3: // LUCKY_ANIMAL
          return LUCKY_ANIMAL;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.FORTUNE, new org.apache.thrift.meta_data.FieldMetaData("fortune", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.LUCKY_NUMBERS, new org.apache.thrift.meta_data.FieldMetaData("lucky_numbers", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32))));
    tmpMap.put(_Fields.LUCKY_ANIMAL, new org.apache.thrift.meta_data.FieldMetaData("lucky_animal", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.ENUM        , "Animal")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(FortuneResponse.class, metaDataMap);
  }

  public FortuneResponse() {
  }

  public FortuneResponse(
    java.lang.String fortune,
    java.util.List<java.lang.Integer> lucky_numbers,
    Animal lucky_animal)
  {
    this();
    this.fortune = fortune;
    this.lucky_numbers = lucky_numbers;
    this.lucky_animal = lucky_animal;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public FortuneResponse(FortuneResponse other) {
    if (other.isSetFortune()) {
      this.fortune = other.fortune;
    }
    if (other.isSetLucky_numbers()) {
      java.util.List<java.lang.Integer> __this__lucky_numbers = new java.util.ArrayList<java.lang.Integer>(other.lucky_numbers);
      this.lucky_numbers = __this__lucky_numbers;
    }
    if (other.isSetLucky_animal()) {
      this.lucky_animal = other.lucky_animal;
    }
  }

  public FortuneResponse deepCopy() {
    return new FortuneResponse(this);
  }

  @Override
  public void clear() {
    this.fortune = null;
    this.lucky_numbers = null;
    this.lucky_animal = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getFortune() {
    return this.fortune;
  }

  public FortuneResponse setFortune(@org.apache.thrift.annotation.Nullable java.lang.String fortune) {
    this.fortune = fortune;
    return this;
  }

  public void unsetFortune() {
    this.fortune = null;
  }

  /** Returns true if field fortune is set (has been assigned a value) and false otherwise */
  public boolean isSetFortune() {
    return this.fortune != null;
  }

  public void setFortuneIsSet(boolean value) {
    if (!value) {
      this.fortune = null;
    }
  }

  public int getLucky_numbersSize() {
    return (this.lucky_numbers == null) ? 0 : this.lucky_numbers.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<java.lang.Integer> getLucky_numbersIterator() {
    return (this.lucky_numbers == null) ? null : this.lucky_numbers.iterator();
  }

  public void addToLucky_numbers(int elem) {
    if (this.lucky_numbers == null) {
      this.lucky_numbers = new java.util.ArrayList<java.lang.Integer>();
    }
    this.lucky_numbers.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<java.lang.Integer> getLucky_numbers() {
    return this.lucky_numbers;
  }

  public FortuneResponse setLucky_numbers(@org.apache.thrift.annotation.Nullable java.util.List<java.lang.Integer> lucky_numbers) {
    this.lucky_numbers = lucky_numbers;
    return this;
  }

  public void unsetLucky_numbers() {
    this.lucky_numbers = null;
  }

  /** Returns true if field lucky_numbers is set (has been assigned a value) and false otherwise */
  public boolean isSetLucky_numbers() {
    return this.lucky_numbers != null;
  }

  public void setLucky_numbersIsSet(boolean value) {
    if (!value) {
      this.lucky_numbers = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public Animal getLucky_animal() {
    return this.lucky_animal;
  }

  public FortuneResponse setLucky_animal(@org.apache.thrift.annotation.Nullable Animal lucky_animal) {
    this.lucky_animal = lucky_animal;
    return this;
  }

  public void unsetLucky_animal() {
    this.lucky_animal = null;
  }

  /** Returns true if field lucky_animal is set (has been assigned a value) and false otherwise */
  public boolean isSetLucky_animal() {
    return this.lucky_animal != null;
  }

  public void setLucky_animalIsSet(boolean value) {
    if (!value) {
      this.lucky_animal = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case FORTUNE:
      if (value == null) {
        unsetFortune();
      } else {
        setFortune((java.lang.String)value);
      }
      break;

    case LUCKY_NUMBERS:
      if (value == null) {
        unsetLucky_numbers();
      } else {
        setLucky_numbers((java.util.List<java.lang.Integer>)value);
      }
      break;

    case LUCKY_ANIMAL:
      if (value == null) {
        unsetLucky_animal();
      } else {
        setLucky_animal((Animal)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case FORTUNE:
      return getFortune();

    case LUCKY_NUMBERS:
      return getLucky_numbers();

    case LUCKY_ANIMAL:
      return getLucky_animal();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case FORTUNE:
      return isSetFortune();
    case LUCKY_NUMBERS:
      return isSetLucky_numbers();
    case LUCKY_ANIMAL:
      return isSetLucky_animal();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof FortuneResponse)
      return this.equals((FortuneResponse)that);
    return false;
  }

  public boolean equals(FortuneResponse that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_fortune = true && this.isSetFortune();
    boolean that_present_fortune = true && that.isSetFortune();
    if (this_present_fortune || that_present_fortune) {
      if (!(this_present_fortune && that_present_fortune))
        return false;
      if (!this.fortune.equals(that.fortune))
        return false;
    }

    boolean this_present_lucky_numbers = true && this.isSetLucky_numbers();
    boolean that_present_lucky_numbers = true && that.isSetLucky_numbers();
    if (this_present_lucky_numbers || that_present_lucky_numbers) {
      if (!(this_present_lucky_numbers && that_present_lucky_numbers))
        return false;
      if (!this.lucky_numbers.equals(that.lucky_numbers))
        return false;
    }

    boolean this_present_lucky_animal = true && this.isSetLucky_animal();
    boolean that_present_lucky_animal = true && that.isSetLucky_animal();
    if (this_present_lucky_animal || that_present_lucky_animal) {
      if (!(this_present_lucky_animal && that_present_lucky_animal))
        return false;
      if (!this.lucky_animal.equals(that.lucky_animal))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetFortune()) ? 131071 : 524287);
    if (isSetFortune())
      hashCode = hashCode * 8191 + fortune.hashCode();

    hashCode = hashCode * 8191 + ((isSetLucky_numbers()) ? 131071 : 524287);
    if (isSetLucky_numbers())
      hashCode = hashCode * 8191 + lucky_numbers.hashCode();

    hashCode = hashCode * 8191 + ((isSetLucky_animal()) ? 131071 : 524287);
    if (isSetLucky_animal())
      hashCode = hashCode * 8191 + lucky_animal.getValue();

    return hashCode;
  }

  @Override
  public int compareTo(FortuneResponse other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetFortune()).compareTo(other.isSetFortune());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetFortune()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.fortune, other.fortune);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetLucky_numbers()).compareTo(other.isSetLucky_numbers());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLucky_numbers()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lucky_numbers, other.lucky_numbers);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetLucky_animal()).compareTo(other.isSetLucky_animal());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetLucky_animal()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.lucky_animal, other.lucky_animal);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("FortuneResponse(");
    boolean first = true;

    sb.append("fortune:");
    if (this.fortune == null) {
      sb.append("null");
    } else {
      sb.append(this.fortune);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lucky_numbers:");
    if (this.lucky_numbers == null) {
      sb.append("null");
    } else {
      sb.append(this.lucky_numbers);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("lucky_animal:");
    if (this.lucky_animal == null) {
      sb.append("null");
    } else {
      sb.append(this.lucky_animal);
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class FortuneResponseStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FortuneResponseStandardScheme getScheme() {
      return new FortuneResponseStandardScheme();
    }
  }

  private static class FortuneResponseStandardScheme extends org.apache.thrift.scheme.StandardScheme<FortuneResponse> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, FortuneResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // FORTUNE
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.fortune = iprot.readString();
              struct.setFortuneIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // LUCKY_NUMBERS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list18 = iprot.readListBegin();
                struct.lucky_numbers = new java.util.ArrayList<java.lang.Integer>(_list18.size);
                int _elem19;
                for (int _i20 = 0; _i20 < _list18.size; ++_i20)
                {
                  _elem19 = iprot.readI32();
                  struct.lucky_numbers.add(_elem19);
                }
                iprot.readListEnd();
              }
              struct.setLucky_numbersIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // LUCKY_ANIMAL
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.lucky_animal = Animal.findByValue(iprot.readI32());
              struct.setLucky_animalIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, FortuneResponse struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.fortune != null) {
        oprot.writeFieldBegin(FORTUNE_FIELD_DESC);
        oprot.writeString(struct.fortune);
        oprot.writeFieldEnd();
      }
      if (struct.lucky_numbers != null) {
        oprot.writeFieldBegin(LUCKY_NUMBERS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, struct.lucky_numbers.size()));
          for (int _iter21 : struct.lucky_numbers)
          {
            oprot.writeI32(_iter21);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.lucky_animal != null) {
        oprot.writeFieldBegin(LUCKY_ANIMAL_FIELD_DESC);
        oprot.writeI32(struct.lucky_animal.getValue());
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class FortuneResponseTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public FortuneResponseTupleScheme getScheme() {
      return new FortuneResponseTupleScheme();
    }
  }

  private static class FortuneResponseTupleScheme extends org.apache.thrift.scheme.TupleScheme<FortuneResponse> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, FortuneResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetFortune()) {
        optionals.set(0);
      }
      if (struct.isSetLucky_numbers()) {
        optionals.set(1);
      }
      if (struct.isSetLucky_animal()) {
        optionals.set(2);
      }
      oprot.writeBitSet(optionals, 3);
      if (struct.isSetFortune()) {
        oprot.writeString(struct.fortune);
      }
      if (struct.isSetLucky_numbers()) {
        {
          oprot.writeI32(struct.lucky_numbers.size());
          for (int _iter22 : struct.lucky_numbers)
          {
            oprot.writeI32(_iter22);
          }
        }
      }
      if (struct.isSetLucky_animal()) {
        oprot.writeI32(struct.lucky_animal.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, FortuneResponse struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(3);
      if (incoming.get(0)) {
        struct.fortune = iprot.readString();
        struct.setFortuneIsSet(true);
      }
      if (incoming.get(1)) {
        {
          org.apache.thrift.protocol.TList _list23 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.I32, iprot.readI32());
          struct.lucky_numbers = new java.util.ArrayList<java.lang.Integer>(_list23.size);
          int _elem24;
          for (int _i25 = 0; _i25 < _list23.size; ++_i25)
          {
            _elem24 = iprot.readI32();
            struct.lucky_numbers.add(_elem24);
          }
        }
        struct.setLucky_numbersIsSet(true);
      }
      if (incoming.get(2)) {
        struct.lucky_animal = Animal.findByValue(iprot.readI32());
        struct.setLucky_animalIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}
