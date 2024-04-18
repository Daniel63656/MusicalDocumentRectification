grammar MusicScript;

track: (system NEWL)* system;
system: barline? measure+;
measure: event+ barline;
event: 'T' stafflet+ ('&' stafflet+)? | 'L' stafflet+;
stafflet: CLEF | key | time | OTTV? voicelet+ OTTV?;
voicelet: (NEWV | SKPV+)? element;
element: TUPL? rest | (GRACE chord)* TUPL? chord;
rest: REST BEAM? DOT*;
chord: 'w' note_open+ DOT* | STEM note_open+ DOT* | STEM note_solid+ DOT* | STEM BEAM? FLAG note_solid+ DOT*;
note_open: accidental? TIE_END? NOTE_OPEN TIE_START?;
note_solid: accidental? TIE_END? NOTE_SOLID TIE_START?;
accidental: SHARP | FLAT | NATURAL | 'x' | 'B';
barline: REPEAT? BARL REPEAT?;
time: DIGIT+ SLASH DIGIT+ | 'c' | '/c';
key: SHARP+ | FLAT+ | NATURAL+;

// TERMINALS
NEWL: '\n';
BARL: '|';
REPEAT: ':';
NEWV: '+';
SKPV: ';';
GRACE: 'g';
REST: '=' | '-' | 'z' | 'r'[1-5];
DOT: '.';
TIE_START: '(';
TIE_END: ')';
FLAG: 'f'[1-5];
BEAM: '[' | ']';
TUPL: '{' | '}';
STEM: 'u' | 'd';
NOTE_OPEN: 'o' '-'? [0-9]+;
NOTE_SOLID: 's' '-'? [0-9]+;
SHARP: '#';
FLAT: 'b';
NATURAL: 'n';
CLEF: 'G' | 'F';
DIGIT: [0-9];
SLASH: '/';
OTTV: 'va' | 'vb' | 'ma' | 'mb';