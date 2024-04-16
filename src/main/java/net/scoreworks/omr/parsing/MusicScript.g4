grammar MusicScript;

track: event+ barline;
event: barline? 'T' stafflet+ ('&' stafflet+)? | barline? 'L' stafflet+;
stafflet: CLEF | key | time | OTTV? voicelet+ OTTV?;
voicelet: (NEWV | SKPV+)? element;
element: rest | (GRACE chord)* chord | tuplet;
tuplet: '{' element+ '}';
rest: REST BEAM? DOT*;
chord: note_open+ DOT* | STEM note_open+ DOT* | STEM note_solid+ DOT* | STEM BEAM? FLAG note_solid+ DOT*;
note_open: accidental? TIE_END? NOTE_OPEN TIE_START?;
note_solid: accidental? TIE_END? NOTE_SOLID TIE_START?;
accidental: SHARP | FLAT | NATURAL | 'x' | '-';
barline: REPEAT? BARL REPEAT?;
time: DIGIT+ SLASH DIGIT+ | 'c' | '/c';
key: SHARP+ | FLAT+ | NATURAL+;

// TERMINALS
BARL: '|';
REPEAT: ':';
NEWV: '+';
SKPV: ';';
GRACE: 'g';
REST: 'r'[0-7];
DOT: '.';
TIE_START: '(';
TIE_END: ')';
FLAG: 'f'[1-5];
BEAM: '[' | ']';
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