namespace go fortune

service FortuneTeller {
  FortuneResponse GetFortune(1: FortuneRequest fortuneRequest),
}

struct FortuneRequest {
  1: string name,
  2: optional Car optionalCar,
}


struct Car {
  1: string make,
  2: string model,
  3: i32 year,
}

struct FortuneResponse {
  1: string fortune,
}

enum Animal {
  MONKEY = 0,
  OWL = 1,
  ANT = 2,
  LIZARD = 3,
  CAT = 4,
}
