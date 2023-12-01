grammar MusicScript;

score: 'bos' event+ 'eos';
event: BARL? STAFF staff ('&' staff)?;
staff: meta* ottavastart? group+ ottavaend?;
group: NEWV? rest VEND? | NEWV? chord VEND? | GRACE chord group;
rest: REST BEAM? DOT*;
chord: WHOLE note+ DOT* | HALF STEM note+ DOT* | STEM note+ DOT* | STEM BEAM? FLAG? note+ DOT*;
note: accidental? TIE_END? LINE TIE_START?;
accidental: SHARP | FLAT |NATURAL | 'x' | '-';
meta: CLEF | time | key;
time: DIGIT+ SLASH DIGIT+;
key: SHARP+ | FLAT+ | NATURAL+;
ottavastart: OTTV;
ottavaend: OTTV;

// TERMINALS
STAFF: 'T' | 'L';
BARL: '|';
NEWV: '<';
VEND: '>';
GRACE: 'g';
REST: 'r'[0-7];
WHOLE: 'w';
HALF: 'h';
DOT: '.';
TIE_START: '(';
TIE_END: ')';
FLAG: 'f'[1-5];
BEAM: '[' | '=' | ']';
STEM: 'up' | 'dn';
LINE: 'l-10' | 'l-9' | 'l-8' | 'l-7' | 'l-6' | 'l-5' | 'l-4' | 'l-3' | 'l-2' | 'l-1' | 'l0' | 'l1' | 'l2' | 'l3' | 'l4' | 'l5' | 'l6' | 'l7' | 'l8' | 'l9' | 'l10' | 'l11' | 'l12' | 'l13' | 'l14' | 'l15' | 'l16' | 'l17' | 'l18';
SHARP: '#';
FLAT: 'b';
NATURAL: 'n';
CLEF: 'gclef' | 'fclef';
DIGIT: [0-9];
SLASH: '/';
OTTV: '8va' | '8vb';