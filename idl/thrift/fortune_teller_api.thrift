namespace java fortune
namespace go fortune
namespace py fortune

// Defines an unfortunate fortunate
exception UnfortunateException {
  1: i32 error_code,
  2: string message
}

/*
 * A service capable of reading your fortune
 */
service FortuneTeller {
  FortuneResponse GetFortune(1: FortuneRequest fortune_request) throws (1: UnfortunateException unfortunate),
}

/*
 * Defines the request struct for the fortune getter
 */
struct FortuneRequest {
  1: required string name, /* required indicates that the field must always be present in every message */
  2: optional Car optional_car, // Optional allows the field to be omitted
  3: VehicleDescription vehicle_description, // https://thrift.apache.org/docs/idl#field-requiredness  "default requiredness"
  4: list<i32> finger_lengths, // "default requiredness" seems like a smell to me.
  5: map<string, i32> sibling_ages,
}

// The union is by default optional and indicates that only one of the two fields is present
union VehicleDescription {
  1: string car_nickname,
  2: i32 bike_frame_size_cm
}

/* Comments are in the style of C */
struct Car {
  1: string make,
  2: string model,
  3: i32 year,
}

// Defines the response struct for the fortune request
struct FortuneResponse {
  1: string fortune,
  2: list<i32> lucky_numbers,
  3: Animal luckY_animal,
}

// Enumerated types are always set to int constants, as in C
enum Animal {
  MONKEY = 0,
  OWL = 1,
  ANT = 2,
  LIZARD = 3,
  CAT = 4,
}
